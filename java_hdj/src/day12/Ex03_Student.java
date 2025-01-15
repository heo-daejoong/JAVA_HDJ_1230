package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student {
	/* 
	 * 다음 기능을 갖는 프로그램을 작성하세요
	 * 1. 학생 추가
	 *  - 학년, 반, 번호, 이름 입력
	 * 2. 학생 조회
	 * 3. 종료
	 * 
	 * 2-1. 학년 조회 : 학년
	 * 2-2. 반 조회 : 학년, 반
	 * 2-3. 번호 조회 : 학년, 반, 번호
	 * 2-4. 전체 조회 : X
	 * 
	 * - 학생 클래스 추가
	 * - List를 이용해서 학생들을 관리
	 * - Stream과 람다식을 이용해서 출력을 구현
	 * */

	static Scanner scan = new Scanner(System.in);
	
	static List<Student> list = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
		list.add(new Student(1, 1, 1, "홍길동"));
		list.add(new Student(1, 1, 2, "임꺽정"));
		list.add(new Student(2, 1, 1, "둘리"));
		list.add(new Student(3, 1, 1, "고길동"));
		list.add(new Student(3, 2, 1, "또치"));
		
		int menu;
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			scan.nextLine();
			
			runMenu(menu);
		
		}while(menu != 3);
		
	}

	private static void printMenu() {
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.println("4. 학생 삭제");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			searchStudent();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		case 4:
			deleteStudent();
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}

	private static void insertStudent() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		Student std = new Student(grade, classNum, num, name);
		list.add(std);
		System.out.println("추가가 완료됐습니다.");
		
	}

	private static void searchStudent() {
		int menu;
		
		printSearchMenu();
		
		menu = scan.nextInt();
		
		scan.nextLine();
		
		runSearchMenu(menu);
		
	}
	private static void deleteStudent() {
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		List<Student> tmpList = 
				list.stream()
				.filter(s->s.getName()
				.contains(name))
				.collect(Collectors.toList());
		print(tmpList, s->true, true);
		
		System.out.print("삭제할 학생 번호 : ");
		int count = scan.nextInt();
		
		Student tmp = tmpList.get(count-1);
		
		list.remove(tmp);
	}

	private static void printSearchMenu() {
		System.out.println("----------------");
		System.out.println("2-1. 학년 조회");
		System.out.println("2-2. 반 조회");
		System.out.println("2-3. 번호 조회");
		System.out.println("2-4. 전체 조회");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runSearchMenu(int menu) {
		
		switch(menu) {
		case 1:
			searchGrade();
			break;
		case 2:
			searchClassnum();
			break;
		case 3:
			searchNum();
			break;
		case 4:
			searchAll();
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			
		}
		
	}

	private static void searchGrade() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		
		print(list, s->s.getGrade() == grade);
	}

	

	private static void searchClassnum() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		
		print(list, s->s.getGrade() == grade && s.getClassNum() == classNum);
	}

	private static void searchNum() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();	
		
		print(list, s->s.getGrade() == grade && s.getClassNum() == classNum
				&& s.getNum() == num);
	}

	private static void searchAll() {
			print(list,s->true);
	}

	private static void print(List<Student> list, Predicate<Student> p) {
		print(list, p, false);
	}
	
	private static void print(List<Student> list, Predicate<Student> p, boolean isCount) {
		Stream<Student> stream = list.stream();
		AtomicInteger index = new AtomicInteger(1);
		
		stream
			.filter(p)
			.forEach(s->{
				int num = index.getAndIncrement();
				System.out.println( (isCount ? num + ". " : "") + s);
		});
			
	}
}
@Data
@AllArgsConstructor
class Student{
	private int grade, classNum, num;
	private String name;
	
	@Override
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 " + name;
	}
	
	
}
