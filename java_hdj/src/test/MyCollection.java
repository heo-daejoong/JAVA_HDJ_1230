package test;

import java.util.ArrayList;

import lombok.Data;

public class MyCollection {

	
	public static void main(String[] args) {
		MyCollection e = new MyCollection();
		e.test();
	}
	public void test() {
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("사과","빨강"));
		list.add(new Fruit("메론","초록"));
		list.add(new Fruit("포도","보라"));
		//list.add("맛있는 과일");

		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
@Data
class Fruit{
	String name;
	String color;
	
	public Fruit(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
}