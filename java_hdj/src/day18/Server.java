package day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Server {

	private Socket socket;
	private List<Bank> list;
	
	public void run() {
		Thread t = new Thread(()->{
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				System.out.println("[연결 성공]");
				
				while(true) {
					int menu = ois.readInt();
					runMenu(menu, ois, oos);
				}
			}catch(Exception e) {
				System.out.println("[연결 해제]");
			}
		});
		t.start();
	}

	private void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated method stub
		
	}


}
