package day02;

import java.util.Scanner;

public class Exex01_Practice {

	public static void main(String[] args) {
		/* 정수 num가 2의 배수인지, 3의 배수인지, 6의 배수인지, 2,3,6의 배수가 아닌지를 판별하는 코드를 작성하세요
		 * 2 : 2의 배수
		 * 3 : 3의 배수
		 * 4 : 2의 배수
		 * 5 : 2,3,6의 배수가 아님
		 * 6 : 6의 배수
		 * */
		
		int num = 14;
		
		if(num % 2 == 0) {
			if(num % 3 == 0) {
				System.out.println(num + "는 6의 배수");
			}
			else {
				System.out.println(num + "는 2의 배수");
			}
		}
		else if(num % 3 == 0) {
			System.out.println(num + "는 3의 배수");
		}
		else {
			System.out.println(num + "는 2, 3, 6의 배수가 아님");
		}
		
		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		char operator;
		
		System.out.print("문제");
		
		num1 = scan.nextInt();
		operator = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		System.out.println(num1 + " " + operator + " " + num2);
		
		
	}
}