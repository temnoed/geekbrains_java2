package ru.geekbrains.java2.dz.SinusCosinus;


public class SinCosMain {


	public static void main(String[] args) {

		double result;
		long a;
		for (double x = 0.5; x < 1; x = x + 0.019) {
			a = System.currentTimeMillis();
			for (int i = 0; i < 10000000; i++) {
				result = Math.sin(x);
			}
			System.out.printf("%.3f, %d \n", x, (System.currentTimeMillis() - a));
		}


	}

}
