package day18;

import java.util.List;

import lombok.Data;

@Data
public class Account {

	private Bank2 bank; //은행
	private	String num; //계좌번호
	private String name; //이름
	private String pw; //비밀번호
	private	int money; //잔액
	
	List<Item> list; //입출금 내역
}
