package com.airatgaliev.hourse_min_path.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airatgaliev.hourse_min_path.model.Count;
import com.airatgaliev.hourse_min_path.model.Hourse;
import com.airatgaliev.hourse_min_path.model.interfaces.Chessman;
import com.airatgaliev.hourse_min_path.service.BFS;

@RestController
@RequestMapping(value = "/hourse/rest")
public class HoursePathController {

	private static final String TEMPLATE = "%d";

	@Autowired
	private BFS<Chessman> bfs;

	@Autowired
	private Hourse hourse;

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public HttpEntity<Count> count(@RequestParam(value = "width", defaultValue = "8") int width,
			@RequestParam(value = "height", defaultValue = "8") int height,
			@RequestParam(value = "start", defaultValue = "a1") String start,
			@RequestParam(value = "end", defaultValue = "h8") String end) {
		int startX, startY, endX, endY, minPath;
		try {
			startX = NumberFromExcelColumn(start.replaceAll("[0-9]", ""));
			startY = Integer.parseInt(start.replaceAll("[a-z]", "")) - 1;
			endX = NumberFromExcelColumn(end.replaceAll("[0-9]", ""));
			endY = Integer.parseInt(end.replaceAll("[a-z]", "")) - 1;
			minPath = bfs.getMinPath(width, height, startX, startY, endX, endY, hourse);
			System.out.println(startX + " " + startY + " " + endX + " " + endY);
			System.out.println(minPath);
		} catch (NullPointerException e) {
			minPath = -1;
		}
		Count count = new Count(String.format(TEMPLATE, minPath));
		count.add(linkTo(methodOn(HoursePathController.class).count(width, height, start, end)).withSelfRel());

		return new ResponseEntity<>(count, HttpStatus.OK);

	}

	public int NumberFromExcelColumn(String column) {
		int retVal = 0;
		String col = column.toUpperCase();
		for (int iChar = col.length() - 1; iChar >= 0; iChar--) {
			char colPiece = col.charAt(iChar);
			int colNum = colPiece - 64;
			retVal = retVal + colNum * (int) Math.pow(26, col.length() - (iChar + 1));
		}
		return retVal - 1;
	}
}
