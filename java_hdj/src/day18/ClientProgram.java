package day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientProgram {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Scanner scan;
	
	public ClientProgram(Socket socket) {
		this.socket = socket;
		this.scan = new Scanner(System.in);
		
		if(socket == null) {
			return;
		}
		try {
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
		}catch(Exception e) {
			//e.printStackTrace();
		}
	}

	public void run() {
		if(socket == null || ois == null || oos == null) {
			System.out.println("[서버 연결이 실패했습니다.]");
			return;
		}
		
		int menu = 0;
		do {
				try {
				printMenu();
				
				menu = scan.nextInt();
				scan.nextLine();
				
				oos.writeInt(menu);
				
				runMenu(menu);
			}catch(InputMismatchException e) {
				//숫자가 아닌 메뉴를 입력하면
				System.out.println("[메뉴는 숫자입니다.]");
				scan.nextLine();
			}catch(Exception e) {
				
			}
		}while(menu != 3);
	}

	private void printMenu() {
		System.out.print("----------------\r" + 
						 "1. 접속\r" + 
						 "2. 계좌 개설\r" +	
						 "3. 종료\r" +
						 "----------------\r" +
						 "메뉴 선택 : ");
		
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			login();
			break;
		case 2:
			open();
			break;
		case 3:
			break;
		default :
			
		}
		
	}

	private void login() {
		
		Account account = inputAccount();
		System.out.println("[접속 중]");
		System.out.println("[같은 계정으로 다른 사용자가 먼저 사용 중이면 대기할 수 있습니다.]");
		Account account2 = null;
			try {
			//서버와 통신해서 account가 일치하는지 확인 => 서버에게 account와 일치하는 계좌 정보를 달라고 요청
				oos.writeInt(1);
				oos.writeObject(account);
				oos.flush();
				
				account2 = (Account)ois.readObject();
				
			//일치하지 않으면 안내 문구 후 종료
			}catch(Exception e) {
				System.out.println("예외 발생");
			}
			if(account2 == null) {
				System.out.println("[계좌 정보가 잘못되었습니다.]");
				return;
			}
			System.out.println("[계좌에 접속했습니다.]");
			
		int menu = 0;
		do {
			try {
				printLoginMenu();
				
				menu = scan.nextInt();
				scan.nextLine();
				
				runLoginMenu(menu, account2);
			}catch(InputMismatchException e) {
				
			}
		}while(menu != 4);
		
	}

	private Account inputAccount() {
		String bankName;
		do {
			Bank.printBanks();
			System.out.print("은행 : ");
			bankName = scan.nextLine();
			System.out.println(!Bank.check(bankName));
		}while(!Bank.check(bankName));
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("비번 : ");
		String pw = scan.nextLine();
		System.out.print("계좌번호 : ");
		String num = scan.nextLine();
		return new Account(Bank.valueOf(bankName), num, name, pw);
	}

	private void printLoginMenu() {
		System.out.print("----------------\r" + 
						 "1. 예금\r" + 
						 "2. 출금\r" +	
						 "3. 조회\r" +
						 "4. 이전으로\r" +
						 "----------------\r" +
						 "메뉴 선택 : ");
		
	}

	private void runLoginMenu(int menu, Account account) {
		switch(menu) {
		case 1:
			deposit(account);
			break;
		case 2:
			withdrawal(account);
			break;
		case 3:
			check(account);
			break;
		case 4:
			break;
		default:
			
		}
		
	}

	private void deposit(Account account) {
		
		
	}

	private void withdrawal(Account account) {
		
		
	}

	private void check(Account account) {
		
		
	}

	private void open() {
		
		Account account = inputAccount();
		
		System.out.print("비번확인 : ");
		String pw2 = scan.nextLine();
		
		if(!account.getPw().equals(pw2)) {
			System.out.println("[비번과 비번 확인이 일치하지 않습니다.]");
			return;
		}
	
		try {
			//서버에 메뉴 전송
			oos.writeInt(0);
			
			//서버에게 계좌 정보를 전송
			oos.writeObject(account);
			oos.flush();
			
			//서버에게 결과를 받아 출력
			if(ois.readBoolean()) {
				System.out.println("[계좌를 등록했습니다.]");
			}else {
				System.out.println("[계좌 등록에 실패했습니다.]");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
