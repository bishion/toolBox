package com.bizi.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by fangbi.guo on 2015/10/31.
 */
public class SocketServer {
	public static void main(String[] args) throws IOException {
		String s = "";
		final String a;
		a=args[0];

		ServerSocket server = new ServerSocket(8000);
		Socket socket = server.accept();
		InputStream in = socket.getInputStream();
		Scanner scanner = new Scanner(in);
		while (scanner.hasNext()){
			System.out.println(scanner.nextLine());
		}

		OutputStream out = socket.getOutputStream();
		out.write("你好,客户端".getBytes());
		out.flush();
		socket.close();

	}
}
