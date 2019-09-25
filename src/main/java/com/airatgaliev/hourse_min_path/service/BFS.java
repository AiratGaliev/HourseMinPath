package com.airatgaliev.hourse_min_path.service;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.airatgaliev.hourse_min_path.model.ChessBoardCell;
import com.airatgaliev.hourse_min_path.model.interfaces.Chessman;

@Component
public class BFS<T extends Chessman> {

	public int getMinPath(int width, int height, int startX, int startY, int endX, int endY, T t) {
		// проверка, посещена ли ячейка матрицы раньше или нет
		Set<ChessBoardCell> visited = new HashSet<ChessBoardCell>();

		// создать очередь и поставить в очередь первый узел
		Queue<ChessBoardCell> queue = new ArrayDeque<ChessBoardCell>();
		ChessBoardCell startCell = new ChessBoardCell(startX, startY);
		queue.add(startCell);
		if (isValidCell(startX, startY, width, height) && isValidCell(endX, endY, width, height)) {
			// выполняем пока очередь не пуста
			while (!queue.isEmpty()) {
				ChessBoardCell cell = queue.poll();
				cell.setWidth(width);
				cell.setHeight(height);
				int x = cell.getX();
				int y = cell.getY();
				int dist = cell.getDist();
				// если пункт назначения достигнут, вернуть расстояние
				if (x == endX && y == endY)
					return dist;

				// Пропустить, если местоположение посещалось раньше
				if (!visited.contains(cell)) {
					// пометить текущий узел как посещенный
					visited.add(cell);

					// проверяем все 8 возможных движений коня
					// и вставляем в очередь каждое действующее движение
					for (int i = 0; i < 8; ++i) {
						// Получить новую действительную позицию коня
						// из текущей позиции на шахматной доске
						// и поставить ее в очередь на +1 расстояние
						int x1 = x + t.getDx(i);
						int y1 = y + t.getDy(i);
						if (isValidCell(x1, y1, width, height))
							queue.add(new ChessBoardCell(x1, y1, dist + 1));
					}
				}
			}
			return -1;
		} else {
			return -1;
		}

	}

	public boolean isValidCell(int x, int y, int width, int height) {
		if (x >= 0 && x < width && y >= 0 && y < height) {
			return true;
		}
		return false;
	}
}
