package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/post/list")
	public String postList(Model model, Integer po_bo_num) {
		
		po_bo_num = po_bo_num == null ? 0 : po_bo_num;
		
		//�Խñ� ��� ��ü�� ������
		List<PostVO> list = postService.getPostList(po_bo_num);
		
		List<BoardVO> boardList = postService.getBoardList();
		
		model.addAttribute("boardList", boardList);
		
		//ȭ�鿡 �Խñ� ����� ����
		//������ resultType=kr.kh.spring.model.vo.postVO
		model.addAttribute("list", list);
		model.addAttribute("po_bo_num", po_bo_num);
		return "/post/list";
	}
	
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		//��ϵ� �Խ��� ����Ʈ�� ������ ȭ�鿡 ����
		List<BoardVO> list = postService.getBoardList();
		model.addAttribute("list", list);
		return "/post/insert";
	}
	
	@PostMapping("/post/insert")
	public String postInsertPost(Model model, PostVO post, HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		if(postService.insertPost(post, user)) {
			model.addAttribute("url", "/post/list");
			model.addAttribute("msg", "�Խñ��� ����߽��ϴ�.");
		}else {
			model.addAttribute("url", "/post/insert");
			model.addAttribute("msg", "�Խñ��� ������� ���߽��ϴ�.");
		}
		return "/msg/msg";
	}
	
	@GetMapping("/post/detail/{po_num}")
	public String postDetail(Model model, @PathVariable("po_num")int po_num) {
		//�Խñ� ��ȸ���� ����
		postService.updateView(po_num);
		//�Խñ��� ������
		PostVO post = postService.getPost(po_num);
		//ȭ�鿡 ����
		model.addAttribute("post", post);
		return "/post/detail";
	}
	
	@GetMapping("/post/delete/{po_num}")
	public String postDelete(Model model, @PathVariable("po_num")int po_num, HttpSession session) {
		//�α����� ȸ�� ������ ������
		//���� ���� ����
		MemberVO user = (MemberVO) session.getAttribute("user");
		if(postService.deletePost(po_num, user)) {
			model.addAttribute("url", "/post/list");
			model.addAttribute("msg", "�Խñ��� �����߽��ϴ�.");
		}else {
			model.addAttribute("url", "/post/detail/" + po_num);
			model.addAttribute("msg", "�Խñ��� �������� ���߽��ϴ�.");
		}
		return "/msg/msg";
	}
	
	@GetMapping("/post/update/{po_num}")
	public String postUpdate(Model model, @PathVariable("po_num")int po_num, HttpSession session) {
		
		List<BoardVO> list = postService.getBoardList();
		model.addAttribute("list", list);
		
		//�Խñ��� ������
		PostVO post = postService.getPost(po_num);
		//�ۼ������� �ƴ��� Ȯ���ϴ� �۾�
		//���� ���� ����
		MemberVO user = (MemberVO) session.getAttribute("user");
		//�α��� �ȵǾ� �ְų�, ���� �Խñ��̰ų�, �ۼ��ڰ� �ƴϸ�
		if(user == null || post == null || !post.getPo_me_id().equals(user.getMe_id())) {
			model.addAttribute("url", "/post/list");
			model.addAttribute("msg", "�ۼ��ڰ� �ƴϰų� ���� �Խñ��Դϴ�.");
			return "/msg/msg";
		}else {
			//ȭ�鿡 ����
			model.addAttribute("post", post);
			return "/post/update";
		}
		
	}
	
	@PostMapping("/post/update")
	public String postUpdatePost(Model model, PostVO post, HttpSession session) {
		//���� ���� ����
		MemberVO user = (MemberVO) session.getAttribute("user");
		if(postService.updatePost(post, user)) {
			model.addAttribute("msg", "�Խñ��� �����߽��ϴ�.");
		}else {
			model.addAttribute("msg", "�Խñ��� �������� ���߽��ϴ�.");
		}
		model.addAttribute("url", "/post/detail/" + post.getPo_bo_num());
		return "/msg/msg";
	}
}
