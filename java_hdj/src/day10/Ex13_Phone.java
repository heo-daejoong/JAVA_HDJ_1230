package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.plaf.multi.MultiSliderUI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
	
	static ArrayList<Phone> list = new ArrayList<Phone>();

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
		
		System.out.print("번호(예:010-1234-5678) : ");
		String num = scan.nextLine();
		
		//정규표현식 체크 : 000-0000-0000
		String regex = "^\\d{2,3}(-\\d{4}){2}$";
		if(!Pattern.matches(regex, num)) {
			System.out.println("올바른 전화번호가 아닙니다.");
			return;
		}
		Phone pn = new Phone(name, num);
		list.add(pn);
		System.out.println("전화번호를 등록했습니다.");
		//System.out.println(list); //확인용
	}

	private static void updateNum() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		ArrayList<Phone> tmpList = searchPhoneList(name);
		if(!printPhoneNumberList(tmpList, true)) {
			return;
		}
		System.out.print("수정할 번호 선택 : ");
		int index = scan.nextInt() - 1;
		scan.nextLine();
		Phone pn = tmpList.get(index);
		
		System.out.print("이름 : ");
		String newName = scan.nextLine();
		
		System.out.print("번호(예:010-1234-5678) : ");
		String num = scan.nextLine();
		
		pn.update(newName, num);
		System.out.println("수정이 완료됐습니다.");
	}

	private static void deleteNum() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		ArrayList<Phone> tmpList = searchPhoneList(name);
		if(!printPhoneNumberList(tmpList, true)) {
			return;
		}
		System.out.print("삭제할 번호 선택 : ");
		int index = scan.nextInt() - 1;
		Phone pn = tmpList.get(index);
		list.remove(pn); //Objects.equals() => Object.equals
			System.out.println("전화번호가 삭제 되었습니다.");
		
	}

	private static ArrayList<Phone> searchPhoneList(String name) {
		
		ArrayList<Phone> tmpList = new ArrayList<Phone>();
		for(Phone pn : list) {
			if(pn.getName().contains(name)) {
				tmpList.add(pn);
			}
		}
		return tmpList;
	}

	private static void searchNum() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		ArrayList<Phone> pList = searchPhoneList(name);
		printPhoneNumberList(pList, false);
		/*for(Phone pn : list) {
			if(pn.getName().contains(name)) {
				System.out.println(pn);
			}
		}*/
	}
	private static boolean printPhoneNumberList(ArrayList<Phone> pList, boolean isNumber) {
		if(pList == null || pList.size() == 0) {
			System.out.println("결과가 없습니다.");
			return false;
		}
		for(int i = 0; i < pList.size(); i++) {
			if(isNumber) {
				System.out.println(i+1 + ". ");
			}
			System.out.println(pList.get(i));
		}
		return true;
	}

	private static void printMenu() {
		System.out.println("-----------------");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
		
	}

}
@Getter
@Setter
@AllArgsConstructor
class Phone{
	private String name;
	private String num;

	@Override
	public String toString() {
		return name + " : " + num;
	}

	public void update(String newName, String num) {
		this.name = newName;
		this.num = num;
		
	}
}
