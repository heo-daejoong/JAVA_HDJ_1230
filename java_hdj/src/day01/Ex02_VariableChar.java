package day01;

public class Ex02_VariableChar {

	public static void main(String[] args) {
		
		char ch1; // 문자변수 ch1을 선언.
		//System.out.println(ch1); // 에러 발생. 초기화 x
		ch1 = '1'; //저장 가능
		System.out.println(ch1); // 에러가 발생하지 않음. 저장해서 초기화 가능
		
		char ch2 = '한'; // 선언과 동시에 초기화 했기에 사용 가능
		System.out.println(ch2);
		
		char ch3 = '\u0041';
		System.out.println(ch3); // 유니코드 0041에 해당하는 A가 출력
		
		char ch4 = '\\', ch5 = '\n', ch6 = '\"';
		System.out.println(ch4);
		System.out.println(ch5); // 엔터
		System.out.println(ch6);
		
		
	}

}
