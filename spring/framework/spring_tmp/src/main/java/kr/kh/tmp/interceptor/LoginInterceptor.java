package kr.kh.tmp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.tmp.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView mv)
	    throws Exception {
		
		//�Ѱ��� ȸ�� ������ ������
		MemberVO user = (MemberVO)mv.getModel().get("user");
		//ȸ�� ������ ������ => �α��ο� ����������
		if(user != null) {
			//���ǿ� ȸ�� ������ �߰�
			request.getSession().setAttribute("user", user);
		}
	}
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
			return true;
	}
}
