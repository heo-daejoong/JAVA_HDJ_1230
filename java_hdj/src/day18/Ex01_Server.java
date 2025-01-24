package day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Ex01_Server {

	static List<Bank> list = new ArrayList<Bank>();
	
	public static void main(String[] args) {

		int port = 5001;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				Socket socket = serverSocket.accept();
				Thread t = new Thread(()->{
					try {
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
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
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated method stub
		
	}

}
