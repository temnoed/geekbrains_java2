package ru.geekbrains.java2.dz.dz2;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;


public class MainClass {


	public static void main(String[] args) {
		String strTask = "1 3 1 7 3\n2 Ё 2 2\n5 3 7 1\n3 3 1 0";
		int result = 0;
		String[][] array;
		boolean flagArrayCorrect = true;

		array = convertString(strTask);

		//----------- Выводим, суммируем и проверяем массив в одном цикле:
		for (String[] array_Y : array) {
			for (String array_X : array_Y) {
				System.out.print(array_X + " ");


				//------пропускаем элемент, если он не число:
				try {
					result += parseInt(array_X);
				} catch (NumberFormatException e) {
					flagArrayCorrect = false;
				}

			}
			System.out.println();
		}


		if (flagArrayCorrect) System.out.println("Результат задачи: " + result / 2);

	} // end main----------------------------------


	// ------------------------------------------------------------
	// Собственно метод прост: набиваем массив строчками.
	// Главное, красиво оформить try-catch.
	//
	//-------------------------------------------------
	private static String[][] convertString(String strTask) {
		int i = 0;

		String[][] array = new String[strTask.split("\n").length][];

		for (String strPart : strTask.split("\n")) {
			array[i] = strPart.split(" ");


			try {
				asList(array[i]).forEach(Integer::parseInt);
			} catch (NumberFormatException e) {
				System.out.println("convertString(): тут в массиве не число. " + e);
			}
			i++;
		}


		try {
			if (array.length != 4)
				throw new IndexOutOfBoundsException();
			else {
				asList(array).forEach(a -> {
					if (a.length != 4) throw new IndexOutOfBoundsException();
				});
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("convertString(): размер массива не 4 Х 4. " + e);
		}


		return array;
	} //-----end method


} // END--------------------



