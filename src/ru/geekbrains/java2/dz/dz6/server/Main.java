package ru.geekbrains.java2.dz.dz6.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Main {

	static PrintWriter out;
	static Scanner in;
	static  Socket s = null;


	public static void main(String[] args) {

		ServerSocket server = null;
		Scanner console = new Scanner(System.in);
		String strNextMessage;

		try {
			server = new ServerSocket(8189);
			System.out.println("Server created. Waiting for a client...");

			while (true) {
				s = server.accept();

				// когда клиент присоединился:
				System.out.println("Client connected");

				String name;
				name = "Client #";
				out = new PrintWriter(s.getOutputStream());
				in = new Scanner(s.getInputStream());


				// читает сообщения от клиента:
				new Thread(new Runnable() {
					@Override
					public void run() {

						while (true) {
							// если во входном потоке была введена информация:
							if (!s.isClosed() && in.hasNext()) {
								// вычитываем то что было введено
								String w = in.nextLine();

								// и выводим в консоль:
								System.out.println("\n"+ name + ": " + w);
								out.println("Echo from server: " + w);
								out.flush();

								if (w.equalsIgnoreCase("end")) {
									break;
								}
							}
						}
						System.out.println(name + ": disconnected.");

					}
				}).start();


				//  Отправляет строчки клиенту из консоли:
				while (true) {

					strNextMessage = console.nextLine();
					if (!strNextMessage.trim().isEmpty()) {
						sendMsg(strNextMessage);
					}
					if (strNextMessage.equalsIgnoreCase("end")) break;
					System.out.println();
				}

				//	Отключаем клиента:
				try {
					out.flush();
					out.close();
					in.close();
					s.close();
					System.out.println(name + ": disconnected.");

				} catch (IOException exc) {
					exc.printStackTrace();
				}


			}


		// выключает сервер:
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {

				s.close();
				server.close();
				System.out.println("Server closed");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	} // END --- main()

	static void sendMsg(String a) {
		out.println(a);
		out.flush();
	}


} // END --- Main