package day04;

import java.util.Scanner;

public class Ex03_Method {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int gcd = gcd1(num1, num2);
		int lcm = lcm1(num1, num2);
		
		
		System.out.println(num1 + "과 " + num2 + "의 최대 공약수 : " + gcd);
		System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " + lcm);
	}

	/* 기능 : 두 정수의 최대 공약수를 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 두 정수의 최대 공약수 => 정수 => int
	 * 메소드명 : gcd1
	 * */
	 
	int count = 1;
	
	count = 1;
	for(int i = num1; ;i += num1, count++) {
		if(i % num2 == 0) {
			System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " + i + ", 반복횟수 : " + count);
			break;
			System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " + i + ", 반복횟수 : " + count);
		}
	}
	public static int gcd1(int num1, int num2) {
		int gcd = 1;
		
		for(int i = 1; i <= num1 ; i++ ) {
			if(num1 % i == 0) {
				if(num2 % i == 0) {
					gcd = i;
				}
				
			}
		}
		return gcd;
	}
	/* 기능 : 두 정수의 최소 공배수를 알려주는 메소드
	 * 매개변수 : 두 정수
	 * 리턴타입 : int
	 * 메소드명 : lcm1
	 * */
	public static int lcm1(int num1, int num2) {
		
		for(int i = num1; ;i += num1) {
			if(i % num2 == 0) {
				return i;
			}
		}
	}
	
	/* 기능 : 최소값과 최대값 사이의 랜덤한 수를 생성하는 메소드
	 * 매개변수 : int min, int max
	 * 리턴타입 : 
	 * 메소드명 : random1
	 * */
	public static int random1(int min, int max){
		
		return 0;
	}
}
}
