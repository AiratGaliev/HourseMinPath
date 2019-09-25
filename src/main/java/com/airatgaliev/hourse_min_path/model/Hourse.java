package com.airatgaliev.hourse_min_path.model;

import org.springframework.stereotype.Component;

import com.airatgaliev.hourse_min_path.model.interfaces.Chessman;

@Component
public class Hourse implements Chessman {
	private int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
	private int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

	public int getDx(int index) {
		return dx[index];
	}

	public int getDy(int index) {
		return dy[index];
	}

}
