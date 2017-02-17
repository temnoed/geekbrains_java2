//-------------------------------------------------------------------------
//
// Задача: ввести имя шахматной фигуры, сходить ею из одной клетки в другую
// и вывести true или false в зависимости от того можно ли так сходить.
//
// Цвет фигур не определяем, поэтому пешки идут только вперёд.
//
// Успел только: пешка, король и ферзь.
//
//-------------------------------------------------------------------------

package ru.geekbrains.java2.dz.dz1;
import java.util.Scanner;


public class MainClass {
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		Player player = new Player();

		player.enterFigureName();
		player.enterFigurePosition();
		player.enterFigureDestination();
	}

}