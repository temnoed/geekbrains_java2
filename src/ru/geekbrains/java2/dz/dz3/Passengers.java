package ru.geekbrains.java2.dz.dz3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Passengers extends ArrayList<Passenger> implements List<Passenger> {

	Passengers() {
	}

	void enterFromConsole() {
		Scanner scanner = new Scanner(System.in);
		String name;
		int number, flight;

		while (true) {

			System.out.println("Ввести ещё одного пассажира (Enter)? ");
			if (!scanner.nextLine().equals("")) return;

			System.out.println("Введите имя: ");
			name = scanner.nextLine();
			System.out.println("Введите номер документа: ");
			number = scanner.nextInt();
			System.out.println("Введите номер рейса: ");
			flight = scanner.nextInt();

			// Добавляем пассажира в общий список:
			this.add (new Passenger(name, number, flight));
			scanner.nextLine();
		}

	}


	void showSorted() {
		Flights flights = new Flights();

		for (Passenger passenger: this) {
			flights.addPassenger(passenger);
		}

		System.out.println("Всего рейсов: " + flights.size());
		flights.forEach((number, f) -> showFlight(number, flights));
	}

	void showFlight (int number, Flights flights) {
		Flight flight;

		flight = flights.get(number);
		System.out.println(number);
		flight.getPassengers().forEach(passenger -> System.out.println("      " + passenger.getName() ));
		System.out.println();
	}

}
