package ru.geekbrains.java2.dz.dz5;

import static ru.geekbrains.java2.dz.dz5.MainClass.a1;
import static ru.geekbrains.java2.dz.dz5.MainClass.h;


/**
 * Первый поток
 */

public class ThreadVolga extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < h; i++) {
			a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
			if (i % 1000000 == 0) System.out.print("1 ");
		}
	}
}