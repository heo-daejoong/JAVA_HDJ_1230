package kr.kh.spring2.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.service.MemberService;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView mv)
	    throws Exception {
		 //구현   
		MemberVO user = (MemberVO)mv.getModel().get("user");
		HttpSession session = request.getSession();
		if(user == null) {
			return;
		}
		session.setAttribute("user", user);
		//자동 로그인을 체크 안하면 종료
		if(!user.isAuto()) {
			return;
		}
		//쿠키를 생성. 유지시간 7일, 쿠키 이름 LC로. 값은 세션 아이디
		Cookie cookie = new Cookie("LC", session.getId());
		cookie.setPath("/");
		int second = 7 * 24 * 60 * 60;
		cookie.setMaxAge(second);
		//response 객체에 쿠키를 담아서 전송
		response.addCookie(cookie);
		//생성된 쿠키를 클라이언트에 전송
		user.setMe_cookie(session.getId());
		//회원 정보에 쿠키값과 만료시간을 업데이트
		Date date = new Date(System.currentTimeMillis() + second * 1000);
		user.setMe_limit(date);
		memberService.updateCookie(user.getMe_id(), session.getId(), date);
	}
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
			//구현
		System.out.println("인터셉터 : 컨트롤러에 들어가기 전");
			return true;
	}
}