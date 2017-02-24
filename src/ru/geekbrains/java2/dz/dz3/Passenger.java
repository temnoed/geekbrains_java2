package ru.geekbrains.java2.dz.dz3;


public class Passenger {

	private String name;
	private int number;
	private int flight;


	Passenger(String name, int number, int flight) {
		this.name = name;
		this.number = number;
		this.flight = flight;
	}

	public String getName() {
		return name;
	}

	int getFlight() {
		return flight;
	}

	public void setName(String name) {
		this.name = name;
	}

}
