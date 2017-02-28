package ru.geekbrains.java2.lesson5;

/**
 * Created by Home-pc on 27.02.2017.
 */
public class Main {

    StringBuffer stringBuffer = new StringBuffer("");
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.setPriority(10);
        thread1.start();

        MyThread myThread = new MyThread();
        myThread.start();

        try {
            System.out.println("main start");
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println("main: " + i);
            }
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.isAlive();

    }
}
