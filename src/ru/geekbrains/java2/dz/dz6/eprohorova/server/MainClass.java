package ru.geekbrains.java2.dz.dz6.eprohorova.server;


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

                s = server.accept();
                System.out.println("Client connected");
                PrintWriter out;
                Scanner in;
                String name;
                name = "Client #";
                in = new Scanner(s.getInputStream());
                ServerThread ser = new ServerThread(s);
                Thread t1 = new Thread(ser);
                t1.start();
                while (true) {
                    if (!t1.isAlive()) break;
                    if (in.hasNext()) {
                        String w = in.nextLine();
                        System.out.println(name + ": " + w);
                        if (w.equalsIgnoreCase("END")) {
                            System.out.println("Client disconnected");
                            break;
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
