package ru.geekbrains.java2.dz.dz6.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
	private Socket s;
	private PrintWriter out;
	private Scanner in;
	private static int CLIENT_COUNT = 0;
	private String name;

	public ClientHandler(Socket s) {
		try {
			this.s = s;
			out = new PrintWriter(s.getOutputStream());
			in = new Scanner(s.getInputStream());
			CLIENT_COUNT++;
			name = "Client #" + CLIENT_COUNT;

		} catch (IOException e) {
		}
	}


	@Override
	public void run() {

		while (true) {

			// если во входном потоке была введена информация:
			if (in.hasNext()) {
				// вычитываем то что было введено
				String w = in.nextLine();
				// и выводим в консоль:
				System.out.println(name + ": " + w);
				out.println("echo: " + w);
				out.flush();
				if (w.equalsIgnoreCase("END")) break;
			}

		}

		try {
			System.out.println("Client disconnected");
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
