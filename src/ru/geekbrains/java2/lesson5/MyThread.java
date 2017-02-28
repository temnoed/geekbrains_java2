package ru.geekbrains.java2.lesson5;

/**
 * Created by Home-pc on 27.02.2017.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread start");
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println("Thread: " + i);
            }
            System.out.println("Thread end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
