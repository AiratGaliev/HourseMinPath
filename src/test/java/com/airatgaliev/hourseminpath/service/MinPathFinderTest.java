package com.airatgaliev.hourseminpath.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.airatgaliev.hourseminpath.model.Board;
import com.airatgaliev.hourseminpath.model.Cell;
import com.airatgaliev.hourseminpath.model.interfaces.Chessman;

@RunWith(SpringRunner.class)
@SpringBootTest
class MinPathFinderTest {
	
	@Autowired
	private MinPathFinder<Chessman> minPathFinder;

	@Autowired
	private Chessman hourse;

	@Test
	public void testFindMinPath() throws Exception {
		Cell startCell = new Cell(0, 0);
		Cell endCell = new Cell(7, 7);
		Board board = new Board(8, 8);
		assertEquals(6, minPathFinder.findMinPath(board, startCell, endCell, hourse));
	}

}
