package day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private List<Account> list;
	
	public Server(Socket socket2, List<Account> list2) {
		this.socket = socket;
		this.list = list;
		if(socket == null) {
			return;
		}
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
		}catch(Exception e) {
			
		}
	}
	public void run() {
		if(socket == null || ois == null || oos == null) {
			return;
		}
		Thread t = new Thread(()->{
			
			int menu;
			try {
				do {
					menu = ois.readInt();
					runMenu(menu);
				}while(menu != 5);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 0:
			open();
			break;
		case 1:
			login();
			break;
		case 2:
			deposit();
			break;
		case 3:
			withdrawal();
			break;
		case 4:
			check();
		default:
		}
	}
	
	private void login() {
		try {
			//클라이언트가 보낸 계좌 정보를 가져옴
			Account account = (Account)ois.readObject();
			int index = list.indexOf(account);
			Account sendAccount = null;
			if(index >= 0) {
				sendAccount = (Account)list.get(index).clone();
			}
			
			oos.writeObject(sendAccount);
			oos.flush();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	private void open() {
		try {
			//계좌정보를 클라이언트에게 받아옴
			Account account = (Account)ois.readObject();
			
			boolean res = false;
			//있는지 확인해서 없으면 추가
			if(!list.contains(account)) {
				list.add(account);
				res = true;
			}
			//추가 여부를 클라이언트에게 전송
			oos.writeBoolean(res);
			oos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void deposit() {
		
		
	}
	private void withdrawal() {
		
		
	}
	private void check() {
		
		
	}
	
}

