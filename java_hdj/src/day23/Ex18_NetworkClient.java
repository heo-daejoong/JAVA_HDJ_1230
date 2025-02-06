package day23;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Ex18_NetworkClient {

	public static void main(String[] args) {
		
		//ip, port 설정
		//ip 설정 시 내부 아이피로 설정하면 한 pc에서 테스트할 땐 동작되지만 여러 pc에서 테스트할 땐 안됨
		String ip = "127.0.0.1";
		int port  = 3001;
		
		try {
			//ip, port를 이용하여 소켓 생성
			Socket socket = new Socket(ip, port);
			System.out.println("[연결 완료]");
			//데이터를 주고 받음
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("안녕");
			oos.flush();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
