package kr.kh.spring2.service;

import java.util.Date;

import kr.kh.spring2.model.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

	void updateCookie(String me_id, String id, Date date);

	MemberVO getMemberByCookie(String me_cookie);

	

}
