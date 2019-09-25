package com.airatgaliev.hourseminpath.model.interfaces;

import com.airatgaliev.hourseminpath.model.Cell;

public interface Chessman {

	Cell getNextCellFrom(Cell current, int possibleMovement);

	int getPossibleMovementCnt();
}
