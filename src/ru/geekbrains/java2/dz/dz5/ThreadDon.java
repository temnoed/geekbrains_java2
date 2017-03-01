package ru.geekbrains.java2.dz.dz5;

import static ru.geekbrains.java2.dz.dz5.MainClass.a2;
import static ru.geekbrains.java2.dz.dz5.MainClass.h;


/**
 * Второй поток
 */

public class ThreadDon extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < h; i++) {
			a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
			if (i % 1000000 == 0) System.out.print("2 ");
		}
	}
}