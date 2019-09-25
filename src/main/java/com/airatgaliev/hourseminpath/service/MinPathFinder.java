package com.airatgaliev.hourseminpath.service;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.airatgaliev.hourseminpath.model.Board;
import com.airatgaliev.hourseminpath.model.Cell;
import com.airatgaliev.hourseminpath.model.interfaces.Chessman;

@Component
public class MinPathFinder<T extends Chessman> {

	public int findMinPath(Board board, Cell startCell, Cell endCell, T t) {

		if (!board.contains(startCell) || !board.contains(endCell)) {
			return -1;
		}
		Set<Cell> visited = new HashSet<>();
		Queue<Cell> queue = new ArrayDeque<>();
		queue.add(startCell);
		while (!queue.isEmpty()) {
			Cell cell = queue.poll();
			if (cell.isCurrentPosition(endCell))
				return cell.getDist();
			if (visited.contains(cell)) {
				continue;
			}
			visited.add(cell);
			for (int i = 0; i < t.getPossibleMovementCnt(); ++i) {
				Cell currentCell = t.getNextCellFrom(cell, i);
				if (board.contains(currentCell))
					queue.add(currentCell);

			}
		}
		return -1;

	}
}
