package test;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Test t = new Test();
		t.count();
		
	}
	
	public static void count() {
		
		Scanner scan = new Scanner(System.in);
		
		String str;
		do {
			System.out.print("문자열을 입력해주세요 : ");
			str = scan.next();
			System.out.println(str.length() + "글자 입니다.");
		}while(!str.equals("exit"));
		System.out.println("프로그램을 종료합니다.");
	}
}
