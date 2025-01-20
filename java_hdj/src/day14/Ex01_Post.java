package day14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex01_Post {

	/* 게시글 프로그램을 위한 클래스를 선언하세요.
	 * 게시글 등록
	 *  - 제목, 내용, 작성자를 입력
	 * 게시글 수정
	 *  - 게시글 번호를 선택
	 *  - 제목, 내용을 수정
	 * 게시글 삭제
	 *  - 게시글 번호를 선택해서 삭제
	 * 게시글 조회
	 *  - 게시글 번호를 이용하여 조회하고 조회수 1증가 
	 * */
	
	static Scanner scan = new Scanner(System.in);
	
	static List<Post> list = new ArrayList<Post>();
	
	public static void main(String[] args) {
		
		int menu;
		
		final int EXIT = 5;
		
		String fileName = "src/day14/Post.txt";
		
		load(fileName, list);
		
		do {
			
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != EXIT);
		
		save(fileName, list);
	}

	private static void load(String fileName, List<Post> list2) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			List<Post> tmp = (ArrayList<Post>) ois.readObject();
			
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

	private static void save(String fileName, List<Post> list2) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
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
		System.out.print("-------------------\r" + 
						 "1. 게시글 작성\r" +
						 "2. 게시글 수정\r" +
						 "3. 게시글 삭제\r" +
						 "4. 게시글 조회\r" + 
						 "5. 프로그램 종료\r" +
						 "-------------------\r" +
						 "메뉴 선택 : ");
			
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertPost();
			break;
		case 2:
			updatePost();
			break;
		case 3:
			deletePost();
			break;
		case 4:
			searchPost();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 메뉴 선택입니다.");
		}
		
	}

	private static void insertPost() {
		inputPost();
		
		printPost();
	}

	private static void printPost() {
		
		
	}


	private static void updatePost() {
		System.out.print("게시글 번호 : ");
		int num = scan.nextInt();
		
		List<Post> tmpList 
					= list.stream().filter(s->s.getNum() == num)
					.collect(Collectors.toList());
		
		if(tmpList.size() == 0) {
			System.out.println("게시글이 존재하지 않습니다.");
			return;
		}
		for(int i = 0; i < tmpList.size(); i++) {
			System.out.println(i+1 + ". " + tmpList.get(i));
		}
		System.out.println("===========================");
		System.out.print("수정할 번호 : ");
		System.out.println("===========================");
		
		int index = scan.nextInt() -1;
		scan.nextLine();
		
		if(index < 0 || index > tmpList.size()) {
			System.out.println("잘못된 번호를 선택했습니다");
			return;
		}
		
		Post post = inputPost();
		tmpList.get(index).update(post);
		
	}

	private static void deletePost() {
		System.out.print("게시글 번호 : ");
		int num = scan.nextInt();
		
		
	}

	private static void searchPost() {
		System.out.print("게시글 번호 : ");
		int num = scan.nextInt();
		
		
	}

	private static Post inputPost() {
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		
	}
}

@Data
@AllArgsConstructor
class Post implements Serializable{
	
	private static final long serialVersionUID = -5042581592019974361L;
	
	private static int count;
	private int num;
	private String title, content, writer;
	private Date date;
	private int view;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return num == other.num;
	}

	public Post(String title, String content, String writer) {
		num = ++count;
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
	}
	
	public void print() {
		System.out.println("===========================");
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + getDateStr());
		System.out.println("조회수 : " + view);
		System.out.println("===========================");
	}

	private String getDateStr() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	@Override
	public String toString() {
		return num + ". " + "제목 : " + title + " " + "내용 : "+ content + " " 
				+ "작성자 : " + writer + " " + "작성일 : " + getDateStr() + " " + "조회수 : " + view;
	}
	
}