package day20;

import lombok.Data;

@Data
public class StationeryProduct extends Product1{

	//분류마다 제품 코드를 할당할 때 등록된 제품 수를 활용하기 때문
	//클래스 변수를 이용
	private static int count = 0;
}
