package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex09_ObjectStream2 {
	/* 다음 기능을 갖는 프로그램을 작성하세요.
	 * 단, 저장기능과 불러오기 기능을 추가
	 *  - 저장은 프로그램 종료할 때
	 *  - 불러오기는 프로그램 시작 전
	 *  
	 * 1. 자동차 추가
	 * 2. 자동차 조회(전체)
	 * 3. 종료
	 * 
	 * 힌트
	 * ArrayList 클래스도 Serializable 인터페이스를 구현한 구현 클래스이다.
	 * */

	static Scanner scan = new Scanner(System.in);
		
	static List<Car> list = new ArrayList<Car>();
	
	public static void main(String[] args) {
		
		String filename = "src/day12/car.txt";
		
		int menu;
		
		load(filename, list);
		
		do {
			
			printMenu();
			
			menu = scan.nextInt();
			
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != 3);
		
		save(filename, list);
		
	}

	private static void load(String filename, List<Car> list) {
		
		try(FileInputStream fis = new FileInputStream(filename);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			List<Car> tmp = (ArrayList<Car>) ois.readObject();
			
			list.addAll(tmp);
		
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}
		
	}

	private static void save(String filename, List<Car> list) {
		
		try(FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
		
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}
		
	}

	private static void printMenu() {
		System.out.println("1. 자동차 추가");
		System.out.println("2. 자동차 조회(전체)");
		System.out.println("3. 종료");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertCar();
			break;
		case 2:
			printCar();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴 선택이 아닙니다.");
		}
	}

	private static void insertCar() {
		System.out.print("자동차 브랜드 : ");
		String brand = scan.nextLine();
		
		System.out.print("자동차 이름 : ");
		String name = scan.nextLine();
		
		list.add(new Car(name, brand));
		
	}

	private static void printCar() {
		//브랜드를 비교하여 다르면 사전순으로 정렬
		list.sort((o1, o2)->{
			if(!o1.getBrand().equals(o2.getBrand())) {
				return o1.getBrand().compareTo(o2.getBrand());
			}
			//이름을 사전순으로 정렬
			return o1.getName().compareTo(o2.getName());
		});
		
		for(Car car : list) {
			System.out.println(car);
		}
		
	}


	
	}

@Data
@AllArgsConstructor
class Car implements Serializable{
	
	private static final long serialVersionUID = 1455289863100321662L;
	private String name, brand;

	@Override
	public String toString() {
		return brand + " : " + name;
	}
	
	
}