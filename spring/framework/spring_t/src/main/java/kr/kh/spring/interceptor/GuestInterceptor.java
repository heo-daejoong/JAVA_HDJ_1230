package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MessageService;

public class GuestInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MessageService messageService;
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {

	}
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//���ǿ� �ִ� ȸ�� ������ ������
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		//ȸ�� ������ ������
		if(user == null) {
			return true;
		}
		//�ƴϸ� ���� �������� ����
		messageService.sendMessage(response, request, "�α����� ȸ���� ������ �� ���� �������Դϴ�.", "/");
		return false;
	}
}