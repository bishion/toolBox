package com.bizi.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by fangbi.guo on 2015/11/4.
 */
public class SocketClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",8000);

		OutputStream out = socket.getOutputStream();
		out.write("Hello\nWorld".getBytes());
		out.flush();

		InputStream in = socket.getInputStream();
		Scanner scanner = new Scanner(in);
		while (scanner.hasNext()){
			System.out.print(scanner.nextLine());
		}


		socket.close();
	}
}
