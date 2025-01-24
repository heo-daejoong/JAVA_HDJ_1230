package day18;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Bank implements Serializable{

	private static final long serialVersionUID = -4585362708055321905L;
	
	private String bankName, name;
	private int bankNum, passWord, passWordTo;
	
	public Bank(String bankName, String name, int bankNum, int passWord, int passWordTo) {
		
		this.bankName = bankName;
		this.name = name;
		this.bankNum = bankNum;
		this.passWord = passWord;
		this.passWordTo = passWordTo;
	}
	
	
}
