/**
 * 1. Разобраться с исходным кодом клиентской и серверной части,
 * и для закрепления написать консольные эхо-сервер и клиент,
 * без подглядывания в методичку;

 2. * Написать консольный вариант клиент\серверного приложения,
 в котором пользователь может писать сообщения,
 как на клиентской стороне, так и на серверной.
 Т.е. если на клиентской стороне написать "Привет",
 нажать Enter, то сообщение должно передаться на сервер
 и там отпечататься в консоли.
 Если сделать то же самое на серверной стороне, сообщение,
 соответственно, передаётся клиенту и печатается у него в консоли.
 Есть одна особенность, которую нужно учитывать:
 клиент или сервер может написать несколько сообщений подряд,
 такую ситуацию необходимо корректно обработать.

 ВАЖНО! Сервер общается только с одним клиентом,
 т.е. не нужно запускать цикл, который будет ожидать второго/третьего/... клиентов.
 (Если будете делать вариант со звездочкой, первую часть дз выполнять НЕ НАДО)
 */

package ru.geekbrains.java2.dz.dz6.server;

import ru.geekbrains.java2.lesson6.server.ClientHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		ServerSocket server = null;
		Socket s = null;

		try {
			server = new ServerSocket(8189);
			System.out.println("Server created. Waiting for a client...");


			while (true) {
				// когда клиент присоединился:
				s = server.accept();
				System.out.println("Client connected");

				PrintWriter out;
				Scanner in;
				String name;
				name = "Client #";
				out = new PrintWriter(s.getOutputStream());
				in = new Scanner(s.getInputStream());


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


			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				s.close();
				server.close();
				System.out.println("Server closed");
			} catch (IOException e ) {
				e.printStackTrace();
			}
		}


	}

}
