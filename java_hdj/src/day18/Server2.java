package day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Server2 {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Object list;
	
	public Server2(Socket socket2, List<Account> list2) {
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
		int menu = 0;
		runMenu(menu);
	}
	private void runMenu(int menu) {
		switch(menu) {
		case 0:
			open();
			break;
		case 1:
			deposit();
			break;
		case 2:
			withdrawal();
			break;
		case 3:
			check();
		default:
			
		}
		
	}
	private void open() {
		
		
	}
	private void deposit() {
		
		
	}
	private void withdrawal() {
		
		
	}
	private void check() {
		
		
	}
	
}

