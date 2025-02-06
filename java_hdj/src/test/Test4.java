package test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Test4 {

	public static void main(String[] args) {
		
		String fileName = "src/test/food.txt";
		
		
	}
	
	public void fileSave(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			Food food = new Food("사과", 20);	
			oos.writeObject(food);
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("저장하기 실패");
			System.out.println("-----------------");
		}
	}



@Getter
@Setter
@AllArgsConstructor
class Food implements Serializable{

	private static final long serialVersionUID = 5985372187414297274L;
	
	private String name;
	private int kcal;
	
	@Override
	public String toString() {
		return name + ", " + kcal;
	}
	
}
	
}