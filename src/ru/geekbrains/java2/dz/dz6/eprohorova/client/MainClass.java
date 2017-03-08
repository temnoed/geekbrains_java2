package ru.geekbrains.java2.dz.dz6.eprohorova.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;
        try {
            Socket sock;
            Scanner in;
            PrintWriter out;
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
            Scanner scan = new Scanner(System.in);
            String str = "";

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            if (in.hasNext()) {
                                String w = in.nextLine();
                                System.out.println(w);
                                if (w.equalsIgnoreCase("exit")) break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true) {
                str = scan.nextLine();
                out.println(str);
                out.flush();
                if (str.equalsIgnoreCase("end")) break;
            }
            try {
                sock.close();
            }catch (IOException e) {
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
