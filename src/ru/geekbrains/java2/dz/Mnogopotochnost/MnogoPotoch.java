package ru.geekbrains.java2.dz.Mnogopotochnost;

/**
 *
 * 	Эксперименты с формулой вычисления синуса-косинуса
 * 	для сравнения с си-шарп. Для многопоточности.
 *
 */

import java.io.IOException;




public class MnogoPotoch {

	private static final int SIZE = 10000000;
	private static int h = SIZE / 2;
	private static float[] arr = new float[SIZE];


	public static void main(String[] args) {

		for (int i = 0; i < SIZE; i++) {
			arr[i] = 1;
		}

		long a = System.currentTimeMillis();

		for (int i = 0; i < SIZE; i++) {

			//arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

			arr[i] = (float) (arr[i] * Math.sin(0.2f + i / (5*SIZE)) * Math.cos(0.2f + i / (5*SIZE)) * Math.cos(0.4f + i / (2*SIZE)));

		}

		// фиксируем время:
		System.out.println((System.currentTimeMillis() - a) + " first flow ms");

		try {
			System.in.read();
		} catch (IOException e) {

		}

	}

}
