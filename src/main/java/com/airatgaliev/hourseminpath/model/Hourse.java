package com.airatgaliev.hourseminpath.model;

import org.springframework.stereotype.Component;

import com.airatgaliev.hourseminpath.model.interfaces.Chessman;

@Component
public class Hourse implements Chessman {
	private final int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
	private final int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

	@Override
	public Cell getNextCellFrom(Cell from, int possibleMovement) {
		int x = from.getX() + dx[possibleMovement];
		int y = from.getY() + dy[possibleMovement];
		int dist = from.getDist() + 1;
		return new Cell(x, y, dist);
	}

	@Override
	public int getPossibleMovementCnt() {
		return 8;
	}

}
