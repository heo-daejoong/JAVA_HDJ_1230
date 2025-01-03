package day04;

public class Ex05_Method3 {

	public static void main(String[] args) {
		/* 2단에서 9단까지 구구단을 출력하는 코드를 작성하세요. 단, 메소드를 활용해서*/
		int num = 2;
		
		for(num = 2; num <= 9; num++) {
			System.out.println(num + "단");
			//num단
			for(int i = 1 ;i <= 9 ;i++ ) {
				System.out.println(num + " X " + i +  " = " + num * i);
				
			
				}
			}
		
	}
	/**num단을 출력하는 메소드
	 * 매개변수 : 출력할 단 => int num
	 * 리턴타입 : 없음 => void
	 * 매소드명 : MultipleTable
	 * @param num 출력할 단
	 * @return void 없음
	 * */
	public static void MultipleTable(int num) {
		
		for(num = 2; num <= 9; num++) {
			
		}
		for(int i = 1; i <= 9; i++) {
			
		}
		
	}
}
