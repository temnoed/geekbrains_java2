package ru.geekbrains.java2.dz.dz3;

import java.util.Map;
import java.util.TreeMap;


class Flights extends TreeMap<Integer, Flight> implements Map<Integer, Flight> {

	Flights() {
	}

	void addPassenger(Passenger passenger) {
		Flight flight = new Flight();

		// получаем рейс из дерева рейсов по его ключу-номеру:
		if (this.containsKey(passenger.getFlight())) {    // если такй ключ есть, то используем его:
			flight = this.get(passenger.getFlight());
		}

		// добавляем пассажира в этот рейс:
		flight.addPassenger(passenger);
		// добавляем рейс обратно в дерево рейсов:
		this.put(passenger.getFlight(), flight);
	}

}
