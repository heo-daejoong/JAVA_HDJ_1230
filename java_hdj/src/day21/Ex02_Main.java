package day21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex02_Main {

	/* 단어장 프로그램을 구현하세요.
	 * - 관리자
	 *  - 단어 등록
	 *  - 단어 수정
	 *  - 단어 삭제
	 * - 사용자
	 *  - 단어 검색
	 *  - 내 검색 단어 보기
	 *  
	 *  - 주의사항
	 *   - 중복된 단어 허용
	 *   - 단어는 단어, 품사, 뜻으로 구성
	 *   - 사용자는 아이디로만 구분. 중복된 아이디는 없음
	 *   - 사용자는 회원가입을 따로 하지 않음
	 *   - 관리자는 admin으로 고정
	 *   - 저장과 불러오기 필수
	 *   
	 *  시작 전
	 *  아이디 : admin
	 *  관리자 메뉴 출력
	 *  메뉴 선택 : 
	 *  
	 *  아이디 : abc
	 *  사용자 메뉴 출력
	 *  메뉴 선택 : 
	 * */
	
	private static List<Member> members = new ArrayList<Member>();
	
	private static List<Dictionary> list = new ArrayList<Dictionary>();
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		members.add(new Member("admin", "관리자"));
		
		int menu;
		
		do {
		login();
		
		menu = scan.nextInt();
		scan.nextLine();
		
		}while(menu != 2);
	}


	private static void login() {
		System.out.print("아이디 : ");
		String id = scan.next();
		
		Member member = new Member(id);
		
		Member user = getMember(members, member);
		
		String authority = user != null ? user.getAuthority() : "사용자";
		
		switch(authority) {
		case "사용자":
			runUser(user);
			break;
		case "관리자":
			runAdmin();
			break;
		default:
			System.out.println("[로그인을 실패했습니다.]");
		}
		
	}

	private static void runUser(Member user) {
		int menu;
		
		do {
			printUserMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runUserMenu(menu, user);
		}while(menu != 3);
		
	}

	private static void printUserMenu() {
		System.out.println("--------------------");
		System.out.println("1. 단어 검색");
		System.out.println("2. 내 검색 단어 보기");
		System.out.println("3. 이전으로");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runUserMenu(int menu, Member user) {
		switch(menu) {
		case 1:
			searchWord();
			break;
		case 2:
			recordWord();
			break;
		case 3:
			System.out.println("[이전으로 돌아갑니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
		
	}

	private static void searchWord() {
		
		
	}

	private static void recordWord() {
		
		
	}

	private static void runAdmin() {
		int menu;
		
		do {
			printAdminMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runAdminMenu(menu);
		}while(menu != 4);
		
	}

	private static void printAdminMenu() {
		System.out.println("--------------------");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 이전으로");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runAdminMenu(int menu) {
		switch(menu) {
		case 1:
			insertWord();
			break;
		case 2:
			updateWord();
			break;
		case 3:
			deleteWord();
			break;
		case 4:
			System.out.println("[이전으로 돌아갑니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
		
	}

	private static void insertWord() {
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		System.out.print("품사 : ");
		String speech = scan.nextLine();
		
		System.out.print("뜻 : ");
		String meaning = scan.nextLine();
		
		Dictionary di = new Dictionary(word, speech, meaning);
		
		list.add(di);
		System.out.println("[단어를 등록했습니다.]");
	}

	private static void updateWord() {
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		int index = list.indexOf(new Dictionary(word, "", ""));
		if(index < 0) {
			System.out.println("[일치하는 단어가 없습니다.]");
			return;
		}
		
		System.out.print("품사 : ");
		String speech = scan.nextLine();
		
		System.out.print("뜻 : ");
		String meaning = scan.nextLine();
		
		Dictionary dictionary = list.get(index);
		dictionary.update(speech, meaning);
		
	}

	private static void deleteWord() {
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		if(list.remove(new Dictionary(word, "", ""))) {
			System.out.println("[단어를 삭제했습니다.]");
		}
		else {
			System.out.println("[일치하는 단어가 없습니다.]");
		}
		
	}

	private static Member getMember(List<Member> members, Member member) {
		if(members == null || members.isEmpty()) {
			return null;
		}
		if(member == null) {
			return null;
		}
		int index = members.indexOf(member);
		//아이디가 일치하지 않는 경우
		if(index < 0) {
			return null;
		}
		return members.get(index);
	}

}
