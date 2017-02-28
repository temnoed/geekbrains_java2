package ru.geekbrains.java2.dz.dz5;

public class MainClass {

	static final int size = 10000000;
	static final int h = size / 2;

	public static void main(String[] args) {

		method1();

		method2();

	}


	static void method1() {
		float[] arr = new float[size];

		for (int i = 0; i < size; i++) {
			arr[i] = 1;
		}

		long a = System.currentTimeMillis();

		for (int i = 0; i < size; i++) {
			arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}

		System.out.println(System.currentTimeMillis() - a);

	}

	static void method2() {
		float[] arr = new float[size];

		for (int i = 0; i < size; i++) {
			arr[i] = 1;
		}

		long a = System.currentTimeMillis();

		// разбив массива на 2:

		// просчёт каждой половины:

		// склейка:

		System.out.println(System.currentTimeMillis() - a);

	}


}
