package ru.geekbrains.java2.dz.dz1;




class Figure {


	class Position {
		int x;
		int y;
		char color;
	}

	private String name;
	private Position position = new Position();
	private Position destination = new Position();


	void setName(String name) {
		this.name = name;
	}


	void setPositionX(int x) {
		this.position.x = x;
	}

	void setPositionY(int y) {
		this.position.y = y;
	}

	void setDestinationX(int x) {
		this.destination.x = x;
	}

	void setDestinationY(int y) {
		this.destination.y = y;
	}


	boolean isRightMove() {

		switch (name) {
			case "пешка":
				return new Pawn().isRightMove(position, destination);
			case "ладья":
				return new Rook().isRightMove(position, destination);
			case "конь":
				return new Knight().isRightMove(position, destination);
			case "слон":
				return new Bishop().isRightMove(position, destination);
			case "ферзь":
				return new Queen().isRightMove(position, destination);
			case "король":
				return new King().isRightMove(position, destination);
			default:
				System.out.println("Некорректное имя фигуры. ");
				return false;
		}

	}

}
