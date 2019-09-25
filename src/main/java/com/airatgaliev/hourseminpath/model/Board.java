package com.airatgaliev.hourseminpath.model;

public class Board {
	private final int width;
	private final int height;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public boolean contains(Cell chessBoardCell) {
		return chessBoardCell.getX() >= 0 && chessBoardCell.getX() < width && chessBoardCell.getY() >= 0
				&& chessBoardCell.getY() < height;
	}

}
