package day17;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Record implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int count;
	private String nickName;
	private Date date;
	
	public Record(int count, String nickName) {
		this.count = count;
		
		if(nickName == null) {
			nickName = "";
		}
		//닉네임 3자 이상이면 3자만 추출
		if(nickName.length() > 3) {
			this.nickName = nickName.substring(0, 3);
			return;
		}
		
		//nickName은 최대 3자, 3자 미만이면 남은 자리를 ?로 채움
		int repeatCount = 3 - nickName.length();
		this.nickName = nickName + "?".repeat(repeatCount);
		this.date = new Date();
	}

	@Override
	public String toString() {
		return nickName + " : " + count + "회";
	}
	
	
}
