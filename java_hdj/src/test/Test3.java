package test;

public class Test3 {

	public static void main(String[] args) {
		Person [] pArr = new Person[3];
		
		for(int i = 0; i <= pArr.length; i++) {
			System.out.println(pArr[i].getName());
		}
	}

}

class Person{
	
	String name;

	public char[] getName() {
		return null;
	}
	
}