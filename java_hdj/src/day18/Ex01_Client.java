package day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_Client {

	/* 은행 계좌 관리 프로그램
	 * - 접속
	 *  - 은행, 계좌번호, 비밀번호
	 * - 계좌개설
	 *  - 은행, 이름, 계좌번호, 비밀번호, 비밀번호 확인
	 * - 종료
	 * 
	 * 	- 예금 조회
	 * 	- 입금
	 * 	- 출금
	 * 	- 이전
	 * 
	 * 주의사항
	 *  - 한 계좌에 여러 명이 동시에 접근하는 경우 먼저 접근한 사람이 사용하도록 처리
	 * */
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String ip = "127.0.0.1";
		int port = 5001;
		Socket socket;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		try {
			socket = new Socket(ip, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("[연결 성공]");
			
		}catch(Exception e) {
			System.out.println("[연결 실패]");
			System.out.println("프로그램 종료");
			return;
		}
		
		int menu = 0;
		final int EXIT = 3;
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu, ois, oos);
		}while(menu != EXIT);
	}

	private static void printMenu() {
		System.out.print("----------------\r" + 
						 "1. 접속\r" + 
						 "2. 계좌 개설\r" +	
						 "3. 종료\r" +
						 "----------------\r" +
						 "메뉴 선택 : ");
		
	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 1:
			logIn(ois, oos);
			break;
		case 2:
			bankNum(ois, oos);
			break;
		case 3: 
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}

	private static void logIn(ObjectInputStream ois, ObjectOutputStream oos) {
		System.out.print("은행 : ");
		String bankName = scan.nextLine();
		System.out.print("계좌번호 : ");
		int bankNum = scan.nextInt();
		System.out.print("비밀번호 : ");
		int passWord = scan.nextInt();
		
	}

	private static void bankNum(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			Bank bank = input();
			
			oos.writeObject(bank);
			oos.flush();
			
			boolean res = ois.readBoolean();
			
			if(res) {
				System.out.println("계좌를 개설했습니다.");
			}else {
				System.out.println("계좌 개설에 실패했습니다.");
			}
		}catch(Exception e) {
			System.out.println("예외 발생");
		}
	}

	private static Bank input() {
		System.out.print("은행 : 	");
		String bankName = scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("계좌번호 : ");
		int bankNum = scan.nextInt();
		System.out.print("비밀번호 : ");
		int passWord = scan.nextInt();
		System.out.print("비밀번호 확인 : ");
		int passWordTo = scan.nextInt();
		
		return new Bank(bankName, name, bankNum, passWord, passWordTo);
	}

}
