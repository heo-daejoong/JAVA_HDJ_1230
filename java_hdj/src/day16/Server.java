package day16;

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

	private List<Post> list;
	private Socket socket;
	
	public void run() {
		Thread t = new Thread(()->{
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				//클라이언트가 메뉴를 보내면 서버는 메뉴를 수신
				int menu;
				do {
					menu = ois.readInt();
					runMenu(menu, ois, oos);
				}while(menu != 5);
				
				
				//수신한 메뉴에 따라 작업이 달라짐
			} catch (IOException e) {
				System.out.println("[클라이언트 연결이 끊어졌습니다.]");
			}
			
		});
		t.start();
	}

	private void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated method stub
		
	}
}
