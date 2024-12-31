package day02;

import java.util.Scanner;

public class Ex11_IfOperater {

	public static void main(String[] args) {
		
		/* 두 정수와 산술 연산자를 입력받는 코드를 작성하세요
		 * 예시
		 * 두 정수와 산술 연산자를 입력하세요( 예 : 1 + 2 ) : 3 * 4
		 * 3 * 4
		 * */
		
		int num1, num2;
		char operater;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수와 산술 연산자를 입력하세요( 예 : 1 + 2 ) : ");
		num1 = scan.nextInt();
		operater = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		System.out.println("" + num1 + operater + num2);
		
		/* 연산자가 +이면 두 수의 더한 값을 출력하고
		 * 연산자가 -이면 두 수의 뺀 값을 출력하고
		 * 연산자가 *이면 두 수의 곱을 출력하고
		 * 연산자가 /이면 두 수의 나눈 값을 출력하고
		 * 연산자가 %이면 두 수의 나머지를 출력하고
		 * 산술연산자가 아니면 잘못된 산술연산자입니다 라고 출력
		 * */
		
		if(operater == '+') {
			System.out.println("" + num1 + " " + operater + " " + num2 + " = " + (num1 + num2));
		}
		else if(operater == '-') {
			System.out.println("" + num1 + " " + operater + " " + num2 + " = " + (num1 - num2));
		}
		else if(operater == '*') {
			System.out.println("" + num1 + " " + operater + " " + num2 + " = " + (num1 * num2));
		}
		else if(operater == '/') {
			System.out.println("" + num1 + " " + operater + " " + num2 + " = " + ((double)num1 / num2));
		}
		else if(operater == '%') {
			System.out.println("" + num1 + " " + operater + " " + num2 + " = " + (num1 % num2));
		}
		else {
			System.out.println(operater + "는 잘못된 산술연산자 입니다.");
		}
		
	}

}
