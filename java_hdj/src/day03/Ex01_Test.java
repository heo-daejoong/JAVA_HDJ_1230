package day03;

import java.util.Scanner;

public class Ex01_Test {

	public static void main(String[] args) {
		/* 세 학생의 국어 성적을 입력받아 총점과 평균은 구하는 코드를 작성하세요.
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("세 학생의 국어 성적을 입력하세요 : ");
		
		int kor1, kor2, kor3;
		
		kor1 = scan.nextInt();
		kor2 = scan.nextInt();
		kor3 = scan.nextInt();
		
		int sum = kor1 + kor2 + kor3;
		
		double average = sum / 3.0;
		
		System.out.println("총점 : " + sum + ", 평균 : " + average);
		
		
	}

}
