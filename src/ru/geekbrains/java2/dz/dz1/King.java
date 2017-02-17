package ru.geekbrains.java2.dz.dz1;

import static java.lang.Math.abs;

public class King extends Figure {

	boolean isRightMove(Position position, Position destination) {

		if (Math.abs(destination.x - position.x) <= 1 && Math.abs(destination.y - position.y) <= 1) return true;
		else return false;
	}
}
