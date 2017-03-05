package ru.geekbrains.java2.dz.dz5.AndreyKhoroshavin;

/**
 *
 * Многопоточность для любого количества потоков,
 * выполненная в цикле. По материалам урока-5 курса джава-2.
 * Created by andrey on 01.03.17.
 *
 */
public class Main {
    static final int size = 10000000;
    static final int h =  size / 2 ;

    public static void main(String[] args) {
        float[] arr = new float[size];
        for (int i = 0; i < size ; i++) {
            arr[i] = 1;
        }
        oneThread(arr);
        twoThread(arr);
//        multiThread(arr, 8); ///arr - массив для вычислений, t - количество потоков от 2 до 16

    }

    public static void oneThread ( float[] arr ){
        long a = System.currentTimeMillis();
//        a = System.currentTimeMillis();
        for (int i = 0; i < size ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void twoThread ( float[] arr ){
        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        float[] a2 = new float[h];
        System.arraycopy(arr, h, a2, 0, h);

        MyThread myThread1 = new MyThread(a1, 0);
        MyThread myThread2 = new MyThread(a2, h);
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if ( !thread1.isAlive() && !thread2.isAlive() ) {
            System.arraycopy(myThread1.getArr(), 0, arr, 0, h);
            System.arraycopy(myThread2.getArr(), 0, arr, h, h);
            System.out.println(System.currentTimeMillis() - a);
        }
    }

    public static void multiThread( float[] arr, int t ){ ///arr - массив для вычислений, t - количество потоков от 2 до 16
        long a = System.currentTimeMillis();

        if ( t%2 != 0 ) t++;
        if ( t > 16 ) t = 16;
        if ( t < 2 ) t = 2;

        int h = arr.length / t;

        MyThread[] myThreads = new MyThread[t];
        Thread[] threads = new Thread[t];
        for (int i = 0; i < t ; i++) {
            float[] a1 = new float[h] ;
            System.arraycopy(arr, i * h, a1, 0, h );
            myThreads[i] = new MyThread(a1, i*h);
            threads[i] = new Thread(myThreads[i]);
            threads[i].start();
        }
        for (int i = 0; i < t; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < t; i++) {
            System.arraycopy(myThreads[i].getArr(), 0, arr, i * h, h);
        }
        System.out.println(System.currentTimeMillis() - a);
    }
}
