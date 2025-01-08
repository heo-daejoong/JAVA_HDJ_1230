package day07;

public class Ex01_For {

	public static void main(String[] args) {
		/* 1 ~ 16까지 출력하는 코드
		 * 1 2 3 4 
		 * 5 6 7 8 
		 * 9 10 11 12 
		 * 13 14 15 16
		 * */
		int num = 16, enter = 4;
		
		for(int i = 1; i <= num; i++ ) {
			System.out.print(i + " ");
			//i가 4의 배수일때
			//i를 4로 나누었을 때 나머지가 0과 같으면
			if(i % 4 == 0) {
				System.out.println();
		}
		}
		
	}

}
