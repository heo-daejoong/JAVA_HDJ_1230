package test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Test5 {

	public static void main(String[] args) {
		output();

	}
	
	public static void output() {
		
		String fileName = "src/test/test.txt";
		
		try(FileWriter fw = new FileWriter(fileName)) {
			
			fw.write(97);
			fw.write(65);
			fw.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
