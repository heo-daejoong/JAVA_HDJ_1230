package day05;

public class Ex11_ArrayRandom2 {

	public static void main(String[] args) {
		/* 1 ~ 10 사이의 중복되지 않은 랜덤한 수 6개를 배열에 저장하는 코드를 작성하세요
		 * */
		int count = 0;
		int [] arr = new int[6];
		
		int min = 1, max = 10;
		
		//반복 : 저장된 갯수가 6개가 될때까지
		while(count < arr.length) {
			//랜덤한 수 생성
			int r = (int)(Math.random() * (max - min + 1) + min);
			boolean result = false;
			//배열에 확인해서 랜덤한 수가 있는지 없는지 확인
			//반복 : 배열 전체
			for(int i = 0; i < arr.length; i++) {
				//배열에 꺼낸 값이 랜덤한 수와 일치하면 result를 true로
				if(arr[i] == r) {
					result = true;
					break;
				}
		
			}
			//있으면 (result가 true이면)건너뜀
			if(result) {
				continue;
			}
			//없으면 배열에 저장하고 저장된 갯수를 1 증가
			arr[count] = r;
			count++;
			//arr[count++] = r;
		}
		printArray(arr);
	}

	
	public static boolean contains(int [] arr, int num) {
		for(int i = 0; i < arr.length; i++) {
		
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void printArray(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
