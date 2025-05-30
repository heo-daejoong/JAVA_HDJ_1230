package day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex03_ToDoList {
	
	/* 다음 기능을 갖는 프로그램을 작성하세요.

	 * 1. 할 일 등록
	 * 2. 할 일 삭제
	 * 3. 할 일 조회
	 * 4. 종료
	 * 메뉴 선택 : 1
	 * 등원
	 * 1. 할 일 등록
	 * 2. 할 일 삭제
	 * 3. 할 일 조회
	 * 4. 종료
	 * 메뉴 선택 : 1
	 * 수업
	 * 1. 할 일 등록
	 * 2. 할 일 삭제
	 * 3. 할 일 조회
	 * 4. 종료
	 * 메뉴 선택 : 2
	 * 1. 등원
	 * 2. 수업
	 * 삭제할 할 일을 선택 : 1
	 * 삭제되었습니다.
	 * 1. 할 일 등록
	 * 2. 할 일 삭제
	 * 3. 할 일 조회
	 * 4. 종료
	 * 메뉴 선택 : 3
	 * 1. 수업 
	 * 1. 할 일 등록
	 * 2. 할 일 삭제
	 * 3. 할 일 조회
	 * 4. 종료
	 * 메뉴 선택 : 4
	 * 프로그램이 종료되었습니다.
	 * */
	static Scanner scan = new Scanner(System.in);
	
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		int menu, count = 0;
		
		
		do {
			
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
			
			
		}while(menu != 4);
		
		
		
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertToDo();
			
			break;
		case 2:
			deleteToDo();
			
			break;
		case 3:
			printToDoList();
			
			break;
		case 4:
			break;
		default:
			
		}
	}

	private static void deleteToDo() {
		//할 일 출력
		if(!printToDoList()) {
			return;
		}
		//삭제할 번호 입력
		System.out.print("삭제할 할 일 번호 선택 : ");
		int index = scan.nextInt() - 1;
		
		if(index >= list.size() || index < 0) {
			System.out.println("잘못된 번호입니다.");
			return;
		}
		
		list.remove(index);
	}

	private static boolean printToDoList() {
		
		if(list.size() == 0) {
			System.out.println("등록된 할 일이 없습니다.");
			return false;
		}
		
		//할 일들을 출력
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i));
		}
		return true;
	}

	private static void insertToDo() {
		//안내문구 출력
		System.out.print("할 일 : ");
		//할 일 입력
		String toDo = scan.nextLine();
		//할 일을 할 일 리스트에 추가
		list.add(toDo);
		System.out.println("할 일을 등록했습니다.");
	}

	private static void printMenu() {
		System.out.print("1. 할 일 등록\r\n"
				+ "2. 할 일 삭제\r\n"
				+ "3. 할 일 조회\r\n"
				+ "4. 종료\r\n"
				+ "메뉴 선택 : ");
	}

}
