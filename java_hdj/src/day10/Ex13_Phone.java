package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex13_Phone {
	/* 전화번호를 관리하는 프로그램을 작성하세요.
	 * 1. 전화번호 추가
	 *  - 이름과 전화번호를 입력받아 추가
	 *  - 동명이인이 있을 수 있기 때문에 중복되도 추가
	 * 2. 전화번호 수정
	 *  - 이름을 입력
	 *  - 이름과 일치하는 목록을 출력
	 *  - 수정하려는 전화번호를 선택
	 *  - 새 전화번호를 입력받아 수정
	 * 3. 전화번호 삭제
	 *  - 이름을 입력
	 *  - 이름과 일치하는 목록을 출력
	 *  - 삭제하려는 전화번호를 선택
	 *  - 선택한 전화번호를 삭제
	 * 4. 전화번호 조회
	 *  - 이름을 입력
	 *  - 이름이 포함된 전화번호를 출력
	 * */
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
			
		}while(menu != 5);
		
		
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertNum();
			break;
		case 2:
			updateNum();
			break;
		case 3:
			deleteNum();
			break;
		case 4:
			searchNum();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}
	}

	private static void insertNum() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		
		Phone phoneObj = new Phone(name, num);
		list.add(name);
	}

	private static void updateNum() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		Phone phoneObj = new Phone(name, 0);
		
		int index = list.indexOf(phoneObj);
		if(index < 0) {
			System.out.println("일치하는 이름이 없습니다.");
			return;
		}
		
		list.set(index, name);
		System.out.println("번호를 수정했습니다.");
	}

	private static void deleteNum() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		if(list.remove(new Phone(name, 0))) {
			System.out.println("번호를 삭제했습니다.");
		}
		else {
			System.out.println("일치하는 번호가 없습니다.");
		}
	}

	private static void searchNum() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		int count = 0;
		for(Phone tmp : list) {
			if(tmp.getName().contains(name)) {
				System.out.println(tmp);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("일치하는 단어가 없습니다.");
		}
	}

	private static void printMenu() {
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
		
	}

}
@Data
@AllArgsConstructor
class Phone{
	String name;
	int num;
	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}
	
}
