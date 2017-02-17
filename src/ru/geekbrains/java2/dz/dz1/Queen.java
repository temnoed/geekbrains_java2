package ru.geekbrains.java2.dz.dz1;

class Queen extends Figure {

	boolean isRightMove (Position position, Position destination){

		if (destination.x - position.x == destination.y - position.y) return true;
		else if (destination.x - position.x == position.y - destination.y ) return true;
		else if (position.x - destination.x  == destination.y - position.y ) return true;
		else if (position.x == destination.x) return true;
		else if (position.y == destination.y) return true;
		else return false;
	}
}

