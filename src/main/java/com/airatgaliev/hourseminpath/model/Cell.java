package com.airatgaliev.hourseminpath.model;

public class Cell {
	private int x, y, dist; // координаты ячейки и минимальный путь

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Cell(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDist() {
		return dist;
	}

	public boolean isCurrentPosition(Cell other) {
		return this.x == other.x && this.y == other.y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Cell chessBoard = (Cell) o;

		if (x != chessBoard.x)
			return false;
		if (y != chessBoard.y)
			return false;
		return dist == chessBoard.dist;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		result = 31 * result + dist;
		return result;
	}

}
