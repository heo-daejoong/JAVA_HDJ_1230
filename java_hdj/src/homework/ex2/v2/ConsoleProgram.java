package homework.ex2.v2;

import java.util.List;

public interface ConsoleProgram {

	void run();

	void printMenu();
	
	void runMenu(int menu);
	
	default void load(String fileName) {
		
	}
	
	default void save(String fileName, Object obj) {
		
	}
}
