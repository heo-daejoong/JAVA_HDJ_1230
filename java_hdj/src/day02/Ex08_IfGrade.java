package day02;

public class Ex08_IfGrade {

	public static void main(String[] args) {
		/* 정수 성적이 주어지면 주어진 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 *  A : 90~100
		 *  B : 80~89
		 *  C : 70~79
		 *  D : 60~69
		 *  F : 0~59
		 *  잘못된 점수 : 0보다 작거나 100보다 큰 경우
		 * */
		
		int grade = 90;
		
		if(grade >= 90 && grade <= 100) {
			System.out.println(grade + "점은 A");
			
		} else if(grade >= 80 && grade < 90) {
			System.out.println(grade + "점은 B");
			
		} else if(grade >= 70 && grade < 80) {
			System.out.println(grade + "점은 C");
			
		} else if(grade >= 60 && grade < 70) {
			System.out.println(grade + "점은 D");
			
		} else if(grade >= 0 && grade < 60) {
			System.out.println(grade + "점은 F");
			
		} else {
			System.out.println(grade + "점은 잘못된 점수");
			
		}
				
		
		
		
	}

}
