package homework_;

import java.util.Scanner;

public class Homework {

	/* KBS 일자별 주간 프로그램 편성표
	 * 1. 프로그램 추가
	 * 2. 프로그램 수정
	 * 3. 프로그램 삭제
	 * 4. 프로그램 조회
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 
	 * */
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu;
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != 5);
		
		
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