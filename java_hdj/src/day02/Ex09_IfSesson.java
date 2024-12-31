package day02;

public class Ex09_IfSesson {

	public static void main(String[] args) {
		/* 월이 주어졌을 때 월에 맞는 계절을 출력하세요.
		 * 봄 : 3, 4, 5
		 * 여름 : 6, 7, 8
		 * 가을 : 9, 10, 11
		 * 겨울 : 12, 1, 2
		 * 잘못된 월 : 그 외
		 * */
		
		int month = 3;
		
		if(month < 1 || month > 12) {
			System.out.println("잘못된 월");
		}
		else if(month >= 3 && month <=5) {  // month == 3 || month == 4 || month == 5
			System.out.println(month + "월은 봄");
		}
		else if(month >= 6 && month <=8) {
			System.out.println(month + "월은 여름");
		}
		else if(month >= 9 && month <=11) {
			System.out.println(month + "월은 가을");
		}
		else {
			System.out.println(month + "월은 겨울");
		}
		
	}

}
