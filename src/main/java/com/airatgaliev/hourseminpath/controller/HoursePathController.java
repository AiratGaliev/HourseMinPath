package com.airatgaliev.hourseminpath.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airatgaliev.hourseminpath.model.Board;
import com.airatgaliev.hourseminpath.model.Cell;
import com.airatgaliev.hourseminpath.model.Count;
import com.airatgaliev.hourseminpath.model.interfaces.Chessman;
import com.airatgaliev.hourseminpath.service.MinPathFinder;

@RestController
@RequestMapping(value = "/hourse/rest")
public class HoursePathController {

	private static final String TEMPLATE = "%d";

	@Autowired
	private MinPathFinder<Chessman> bfs;

	@Autowired
	private Chessman hourse;

	@GetMapping(value = "/count")
	public HttpEntity<Count> count(@RequestParam(defaultValue = "8") int width,
			@RequestParam(defaultValue = "8") int height, @RequestParam(defaultValue = "A1") String start,
			@RequestParam(defaultValue = "H8") String end) {
		int minPath = getMinPathCaught(start, end, width, height);
		Count count = new Count(String.format(TEMPLATE, minPath));
		count.add(buildLink(width, height, start, end));

		return ResponseEntity.ok(count);

	}

	private Link buildLink(int width, int height, String start, String end) {
		return linkTo(
				methodOn(HoursePathController.class).count(width, height, start.toUpperCase(), end.toUpperCase()))
						.withSelfRel();
	}

	private int getMinPathCaught(String start, String end, int width, int height) {
		try {
			return getMinPath(start, end, width, height);
		} catch (NullPointerException | NumberFormatException e) {
			return -1;
		}
	}

	private int getMinPath(String start, String end, int width, int height) {
		Cell startCell = CellUtils.parseCell(start);
		Cell endCell = CellUtils.parseCell(end);
		Board board = new Board(width, height);
		return bfs.findMinPath(board, startCell, endCell, hourse);
	}

	
}
