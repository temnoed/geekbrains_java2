package ru.geekbrains.java2.dz.dz5;

import java.util.Arrays;


/**
 * Используем глобальные переменные для наглядности и простоты:
 */
public class MainClass {
	private static final int size = 10000000;
	static final int h = size / 2;
	private static float[] arr = new float[size];
	static float[] a1 = new float[h];
	static float[] a2 = new float[h];



	public static void main(String[] args) {

		System.out.println("Запускаем процесс одним потоком:");
		method1();
		System.out.println("Запускаем процесс двумя параллельными потоками:");
		method2();
	}



	/**
	 * Метод1 идёт одним потоком:
	 */
	private static void method1() {

		Arrays.fill(arr, 1);
		long a = System.currentTimeMillis();

		for (int i = 0; i < size; i++) {
			arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

			// Иллюстрируем процесс отмечая каждую миллионную итерацию:
			if (i % 1000000 == 0) System.out.print("1 ");
		}

		// фиксируем время:
		System.out.println("Прошло " + (System.currentTimeMillis() - a) + " мсек.\n");
	}



	/**
	 * Метод2 идёт двумя параллельными потоками.
	 * Используется два объекта, наследующих класс Thread:
	 */
	private static void method2() {

		Arrays.fill(arr, 1);
		long a = System.currentTimeMillis();

		// раскол массива на 2 части:
		System.arraycopy(arr, 0, a1, 0, h);
		System.arraycopy(arr, h, a2, 0, h);

		// запускаем первый поток:
		ThreadVolga threadVolga = new ThreadVolga();
		threadVolga.start();

		// запускаем второй поток:
		ThreadDon threadDon = new ThreadDon();
		threadDon.start();

		// ждём-с окончания обоих потоков:
		try {
			threadVolga.join();
			threadDon.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// склеиваем массивы и фиксируем время:
		pasteArrays();
		System.out.println("Прошло " + (System.currentTimeMillis() - a) + " мсек.\n");
	}



	/**
	 * Метод склейки массивов делаем синхронизированным на всякий случай:
	 */
	private static synchronized void pasteArrays() {

		System.arraycopy(a1, 0, arr, 0, h);
		System.arraycopy(a2, 0, arr, h, h);
	}



} // END MainClass