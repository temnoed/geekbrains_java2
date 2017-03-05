package ru.geekbrains.java2.dz.dz5.AndreyKhoroshavin;

/**
 * Created by andrey on 01.03.17.
 */
public class MyThread implements Runnable{
    private float[] arr;
    private int h;

    public MyThread(float[] arr, int h) {
        this.arr = arr;
        this.h = h;
    }

    public float[] getArr() {
        return arr;
    }


    @Override
    public void run() {
        for (int i = 0, j = h; i < arr.length ; i++, j++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
//        this.arr = performCalc(this.arr);

    }
//    public synchronized float[] performCalc ( float[] mas ){
//        for (int i = 0; i < mas.length ; i++) {
//            mas[i] = (float)(mas[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        return mas;
//    }
}
