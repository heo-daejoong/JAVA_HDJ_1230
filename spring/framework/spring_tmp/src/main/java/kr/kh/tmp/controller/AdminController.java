package kr.kh.tmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.tmp.model.vo.BoardVO;
import kr.kh.tmp.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/board")
	public String board(Model model) {
		//�Խ��� ����� ������
		List<BoardVO> list = postService.getBoardList();
		//ȭ�鿡 ����
		model.addAttribute("list", list);
		return "/post/board";
	}
	
	@PostMapping("/board/insert")
	public String boardInsert(Model model, String name) {
		if(postService.insertBoard(name)) {
			model.addAttribute("msg", "�Խ����� ����߽��ϴ�.");
		}else {
			model.addAttribute("msg", "�̹� ��ϵ� �Խ����Դϴ�.");
		}
		model.addAttribute("url", "/admin/board");
		return "message";
	}
	
	@PostMapping("/board/update")
	public String boardUpdate(Model model, BoardVO board) {
		if(postService.updateBoard(board)) {
			model.addAttribute("msg", "�Խ����� �����߽��ϴ�.");
		}else {
			model.addAttribute("msg", "�̹� ��ϵ� �Խ����Դϴ�.");
		}
		model.addAttribute("url", "/admin/board");
		return "message";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Model model, int num) {
		if(postService.deleteBoard(num)) {
			model.addAttribute("msg", "�Խ����� �����߽��ϴ�.");
		}else {
			model.addAttribute("msg", "�Խ����� �������� ���߽��ϴ�.");
		}
		model.addAttribute("url", "/admin/board");
		return "message";
	}
}
