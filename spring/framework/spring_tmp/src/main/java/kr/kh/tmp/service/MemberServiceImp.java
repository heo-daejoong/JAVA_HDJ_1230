package kr.kh.tmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.tmp.dao.MemberDAO;
import kr.kh.tmp.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		//���̵�, ���, �̸��� ��ȿ�� �˻�
		
		//��й�ȣ ��ȣȭ
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		try {
			//���Ե� ���̵�� ������ ���
			return memberDao.insertMember(member);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		//���̵� �ٸ� ���
		if(user == null) {
			return null;
		}
		//��й�ȣ�� �ٸ� ���
		if(!passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
		return null;
		}
		return user;
	}
}
