/*
*	Тут получилось нагромождение классов, конечно...
*	И ещё я не успел сделать сортировку по имени, зато работает.
*
*	С праздником, коллеги!
*
 */

package ru.geekbrains.java2.dz.dz3;


public class MainClass {

	public static void main(String[] args) {

		// Сконструируем коллекцию пассажиров:
		Passengers passengers = new Passengers();
		passengers.enterFromConsole();
		// Отобразим её в отсортированном виде по номеру рейса и по фамилии:
		passengers.showSorted();

	}

}
