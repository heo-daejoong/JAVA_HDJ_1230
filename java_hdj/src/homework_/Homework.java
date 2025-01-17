package homework_;

import java.util.ArrayList;
import java.util.Scanner;

public class Homework {

	/* KBS 일자별 주간 프로그램 편성표
	 * 1. 프로그램 추가
	 * 2. 프로그램 수정
	 * 3. 프로그램 삭제
	 * 4. 프로그램 조회
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 1
	 * 일자 : 1.14
	 * 시간 : 12 ~ 2
	 * 프로그램명 : 뉴스데스크
	 * 설명 : 시사
	 * KBS 일자별 주간 프로그램 편성표
	 * 1. 프로그램 추가
	 * 2. 프로그램 수정
	 * 3. 프로그램 삭제
	 * 4. 프로그램 조회
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 4
	 * 1. 1.14 / 12 ~ 2 / 뉴스데스크 / 시사
	 * 번호 선택 : 1
	 * 메뉴 선택 : 1
	 * 일자 : 1.14
	 * 시간 : 12 ~ 2
	 * 프로그램명 : 뉴스데스크
	 * 설명 : 뉴스
	 * KBS 일자별 주간 프로그램 편성표
	 * 1. 프로그램 추가
	 * 2. 프로그램 수정
	 * 3. 프로그램 삭제
	 * 4. 프로그램 조회
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 4
	 * 1. 1.14 / 12 ~ 2 / 뉴스데스크 / 뉴스
	 * KBS 일자별 주간 프로그램 편성표
	 * 1. 프로그램 추가
	 * 2. 프로그램 수정
	 * 3. 프로그램 삭제
	 * 4. 프로그램 조회
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 3
	 * 1. 1.14 / 12 ~ 2 / 뉴스데스크 / 시사
	 * 번호 선택 : 1
	 * 프로그램이 삭제됐습니다.
	 * KBS 일자별 주간 프로그램 편성표
	 * 1. 프로그램 추가
	 * 2. 프로그램 수정
	 * 3. 프로그램 삭제
	 * 4. 프로그램 조회
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 5
	 * 프로그램이 종료됐습니다.
	 * */
	
	static Scanner scan = new Scanner(System.in);
	
	static ArrayList<Program> program = new ArrayList<Program>();
	
	public static void main(String[] args) {
		
		int menu;
		
		final int EXIT = 5;
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != EXIT);
		
		
	}

	private static void printMenu() {
		System.out.print("KBS 일자별 주간 프로그램 편성표\r\n"
				+ "1. 프로그램 추가\r\n"
				+ "2. 프로그램 수정\r\n"
				+ "3. 프로그램 삭제\r\n"
				+ "4. 프로그램 조회\r\n"
				+ "5. 프로그램 종료\r\n"
				+ "메뉴 선택 : ");
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertProgram();
			break;
		case 2:
			updateProgram();
			break;
		case 3:
			deleteProgram();
			break;
		case 4:
			searchProgram();
			break;
		case 5:
			System.out.println("프로그램이 종료됐습니다.");
			break;
		default:
			System.out.println("올바른 메뉴 선택이 아닙니다.");
			
		}
		
		
	}

	private static void insertProgram() {
		System.out.print("일자 : ");
		String day = scan.nextLine();
		System.out.print("시간 : ");
		String time = scan.nextLine();
		System.out.print("프로그램명 : ");
		String name = scan.nextLine();
		System.out.print("설명 : ");
		String explan = scan.nextLine();
	}

	private static void updateProgram() {
		
	}

	private static void deleteProgram() {
		
	}

	private static void searchProgram() {
		
	}

}

class Program{
	String programDay, programTime, programName, programExplan;
}