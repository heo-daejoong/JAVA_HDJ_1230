package day05;

public class Ex09_ArrayRandom {

	public static void main(String[] args) {
		/* 6개짜리 배열을 생성해서 1 ~ 10 사이의 랜덤한 수를 저장하는 출력하는 코드를 작성.
		 * 중복 허용
		 * */
		int size = 6;
		int [] array = new int [size];
		
		
		
		int max = 10, min = 1;
		int r = (int)(Math.random() * (max - min + 1) + min);
		
		for(int i = 0; i < size; i++) {
			array[i] = (int)(Math.random() * (max - min + 1) + min);
			System.out.print(array[i] + " ");
		}
		
		
	}
	/* 크기가 주어지면 min에서 max 사이의 랜덤한 수를 생성하여 배열에 저장하고 저장된 배열을 반환하는 메소드
	 * 매개변수 : 최소값, 최대값, 크기 => int min, int max, int size
	 * 리턴타입 : 랜덤으로 생성된 배열 => 정수 배열 => int[]
	 * 매소드명 : createRandomArray
	 * */
	public static int [] createRandomArray(int min, int max, int size) {
		if(size <= 0) {
			return null;
		}
	}
}
