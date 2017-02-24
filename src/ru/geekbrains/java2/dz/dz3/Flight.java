package ru.geekbrains.java2.dz.dz3;

class Flight {
	private Passengers passengers = new Passengers();


	Passengers getPassengers() {
		return passengers;
	}


	void addPassenger (Passenger passenger) {
		this.passengers.add(passenger);
	}

}
