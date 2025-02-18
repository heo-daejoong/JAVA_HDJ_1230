package practice;

public class Practice {

	public static void main(String[] args) {

		calculate(6, 2, '+');
		
		System.out.println();
	
		plus(6, 2);
		minus(6, 2);
		divide(6, 2);
		power(6, 2);
	
	
	}

	private static void calculate(int i, int j, char c) {
		switch(c) {
		case '+':
			System.out.println("" + i + c + j + " = " + (i + j));
			break;
		case '-':
			System.out.println("" + i + c + j + " = " + (i - j));
			break;
		case '*':
			System.out.println("" + i + c + j + " = " + (i * j));
			break;
		case '/':
			System.out.println("" + i + c + j + " = " + (i / j));
			break;
		}
		
	}

	private static void calculate(int i, int j) {
		System.out.println(i + " + " + j + " = " + (i + j));
		System.out.println(i + " - " + j + " = " + (i - j));
		System.out.println(i + " / " + j + " = " + (i / j));
		System.out.println(i + " * " + j + " = " + (i * j));
		
	}

	private static void power(int i, int j) {
		System.out.println(i + " * " + j + " = " + (i * j));
		
	}

	private static void divide(int i, int j) {
		System.out.println(i + " / " + j + " = " + (i / j));
		
	}

	private static void minus(int i, int j) {
		System.out.println(i + " - " + j + " = " + (i - j));
	}

	private static void plus(int i, int j) {
		System.out.println(i + " + " + j + " = " + (i + j));
	}
}