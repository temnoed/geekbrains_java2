package ru.geekbrains.java2.dz.dz1;

import java.io.Console;

import static ru.geekbrains.java2.dz.dz1.MainClass.sc;


class Player {
	private Figure figure = new Figure();


	void enterFigureName() {

		System.out.println("Введите имя фигуры (пешка, ладья, конь, слон, ферзь, король): ");
		figure.setName(sc.nextLine());
	}


	void enterFigurePosition() {
		String str;

		do {
			str ="";
			System.out.println("Введите клетку ОТКУДА (e2): ");
			str = sc.nextLine();
			figure.setPositionX(getX(str));
			figure.setPositionY(getY(str));
		} while (getX(str) == 0 || getY(str) == 0);
	}


	void enterFigureDestination() {
		String str;

		do {
			str ="";
			System.out.println("Введите клетку КУДА (e4): ");
			str = sc.nextLine();
			figure.setDestinationX(getX(str));
			figure.setDestinationY(getY(str));
		} while (getX(str) == 0 || getY(str) == 0);
		System.out.println("Возможность пойти на " + str + " = " + figure.isRightMove());
	}


	private int getX(String str) {
		char x;

		x = str.charAt(0);
		switch (x) {
			case 'a':
				return 1;
			case 'b':
				return 2;
			case 'c':
				return 3;
			case 'd':
				return 4;
			case 'e':
				return 5;
			case 'f':
				return 6;
			case 'g':
				return 7;
			case 'h':
				return 8;
			default: {
				System.out.println("Неправильный ввод позиции X. ");
				return 0;
			}
		}

	}


	private int getY(String str) {
		int y;

		y = Character.getNumericValue(str.charAt(1));
		if (y > 0 && y < 8) return y;
		else {
			System.out.println("Неправильный ввод позиции Y. ");
			return 0;
		}
	}

}

