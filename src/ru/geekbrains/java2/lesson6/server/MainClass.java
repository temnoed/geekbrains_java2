package ru.geekbrains.java2.lesson6.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket s = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Server created. Waiting for client...");

            while (true) {
                s = server.accept();
                System.out.println("Client connected");

                PrintWriter out;
                Scanner in;
                String name;
                name = "Client #";
                out = new PrintWriter(s.getOutputStream());
                in = new Scanner(s.getInputStream());

                while (true) {
                    if (in.hasNext()) {
                        String w = in.nextLine();
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
