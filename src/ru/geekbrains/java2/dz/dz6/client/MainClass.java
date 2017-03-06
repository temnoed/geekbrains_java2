package ru.geekbrains.java2.dz.dz6.client;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class MainClass {

	final static String SERVER_ADDR = "localhost";
	final static int SERVER_PORT = 8189;
	static Socket sock;
	static Scanner input;
	static Scanner console = new Scanner(System.in);
	static PrintWriter out;
	static String strNextMessage;



	public static void main(String[] args) {

		// Сначала подключаемся к серверу:
		try {
			sock = new Socket(SERVER_ADDR, SERVER_PORT);
			input = new Scanner(sock.getInputStream());
			out = new PrintWriter(sock.getOutputStream());
			System.out.println("Connected to server.");

		} catch (IOException e) {
			e.printStackTrace();
		}


		// обрабатывает послания от сервера:
		new Thread(new Runnable() {
			@Override
			public void run() {
				String w;
				try {

					while (!sock.isClosed()) {
						if (!sock.isClosed() && input.hasNext()) {
							w = input.nextLine();
							if (w.equalsIgnoreCase("end")) {
								break;
							}
							System.out.println("From server: " + w);
						}
					}
					System.out.println("Disconnected from server.");


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();


		//  Отправляет строчки на сервер из консоли, выход - "end":
		while (!sock.isClosed()) {
			strNextMessage = console.nextLine();

			if (!strNextMessage.trim().isEmpty()) {
				sendMsg(strNextMessage);
			}
			if (strNextMessage.equalsIgnoreCase("end")) break;
		}


		//	Отключается от сервера:
		try {
			out.println("end");
			out.flush();
			out.close();
			input.close();
			sock.close();
			System.out.println("Server connection closed.");

		} catch (IOException exc) {
			exc.printStackTrace();
		}


	} // END --- main()


	static void sendMsg(String a) {
		out.println(a);
		out.flush();
	}


} // END --- MainClass