package ru.geekbrains.java2.dz.dz6.eprohorova.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {
    private Socket s;
    private PrintWriter out;
    private Scanner scan;
    private String str;

    public ServerThread(Socket s) {
        try {
            this.s = s;
            out = new PrintWriter(s.getOutputStream());
            str = "";
            scan = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            str = scan.nextLine();
            out.println("Server: " + str );
            out.flush();
            if (str.equals("exit")) {
                out.println("Server disconnected");
                out.flush();
                break;
            }
        }
      try {
           s.close();
        } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
