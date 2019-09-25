package com.airatgaliev.hourseminpath.controller;

import com.airatgaliev.hourseminpath.model.Cell;

public class CellUtils {
	public static Cell parseCell(String cell) throws NumberFormatException {
		int endX = numberFromColumn(cell.replaceAll("[0-9]", ""));
		int endY = Integer.parseInt(cell.toUpperCase().replaceAll("[A-Z]", "")) - 1;
		return new Cell(endX, endY);
	}

	private static int numberFromColumn(String column) {
		int retVal = 0;
		for (int iChar = column.length() - 1; iChar >= 0; iChar--) {
			char colPiece = column.charAt(iChar);
			int colNum = colPiece - 64;
			retVal = retVal + colNum * (int) Math.pow(26, column.length() - (iChar + 1));
		}
		return retVal - 1;
	}
}
