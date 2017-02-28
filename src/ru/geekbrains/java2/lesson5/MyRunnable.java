package ru.geekbrains.java2.lesson5;

/**
 * Created by Home-pc on 27.02.2017.
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Run start");
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println("run: " + i);
            }
            System.out.println("run end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
