package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	//��Ʈ�ѷ����� ���� �� ����ä�� ��� ȣ���� ��
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		//��Ʈ�ѷ��� ������ ȸ�� ������ ������
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		
		//������ ȸ�� ������ ������ ���ǿ� ȸ�� ������ ����
		HttpSession session = request.getSession();
		if(user != null) {
			session.setAttribute("user", user);
		}
	}
	//��Ʈ�ѷ��� ������ ����ä�� ��� ȣ���� ��
	//������ true�̸� ���� URL�� ���� ����
	//������ false�̸� ���� URL�� ���� ����. ���� �� ���� redirect�� �ٸ� URL�� ����� ��.
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
			//����
			return true;
	}
}