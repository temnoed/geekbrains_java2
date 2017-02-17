package ru.geekbrains.java2.dz.dz1;

class Pawn extends Figure {

boolean isRightMove (Position position, Position destination){

		if (position.y == 2) {
			if (destination.y == 3 || destination.y == 4)  return true;
			else return false;
		}

		if (destination.y == position.y + 1) return true;
		else return false;

	}

}
