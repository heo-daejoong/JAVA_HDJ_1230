package day03;

import java.util.Random;
import java.util.Scanner;

public class Ex14_UpDown {

	public static void main(String[] args) {
		/* 1에서 100사이의 랜덤한 수를 생성해서 맞추는 게임을 구현하세요.
		 * 예시
		 * 랜덤한 수 : 30
		 * 입력 : 50
		 * DOWN!
		 * 입력 : 10
		 * UP!
		 * 입력 : 30
		 * 정답!
		 * 
		 * 반복횟수 : 계속
		 * 규칙성 : 정수를 입력. 
		 * 		  입력한 정수가 랜덤한 수보다 크면 DOWN 출력
		 * 		  작으면 UP 출력
		 * 		  같으면 정답 출력
		 * 반복문 종료 후 : 없음
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 100;
		
		int r;
		
		Random random = new Random();
		r = random.nextInt(max - min + 1) + min;
		for( ; ; ) {
			System.out.print("입력 : ");
			int input = scan.nextInt();
			if(input > r) {
				System.out.println("DOWN!");
			}
			else if(input < r){
				System.out.println("UP!");
			}
			else {
				System.out.println("정답!");
				break;
			}
		}
		
		
	}

}
