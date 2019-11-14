package com.problems.CodeWarsSolutions;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;

public class SqInRect {
	public static List<Integer> sqInRectLoop(int lng, int wdth) {
		List<Integer> listSq = new ArrayList<Integer>();
		int length = lng, width = wdth;
		int longestSide;
		int nextBiggestSquare = min(lng, wdth);
		while (nextBiggestSquare > 0) {
			listSq.add(nextBiggestSquare);
			longestSide = max(length, width);
			length = nextBiggestSquare;
			width = longestSide - nextBiggestSquare;
			nextBiggestSquare = min(length, width);
		}
		return listSq;
	}

	public static String sqInRectRecur(int lng, int wdth) {
		int nextBiggestSquare = min(lng, wdth);
		if (nextBiggestSquare == 0) {
			return "";
		}
		int longestSide = max(lng, wdth);
		int otherside = longestSide - nextBiggestSquare;
		return "" + nextBiggestSquare + " , " + sqInRectRecur(otherside, nextBiggestSquare);

	}
	public static void main(String[] args) {
		int length = 100, width = 100;
		long startL = System.nanoTime();
		List<Integer> list = (sqInRectLoop(length, width));
		long endL = System.nanoTime();
		System.out.println("Time taken to execute loop method was " + (endL - startL) / 1000.000 + "\u03BCs.");
		for (int i = 0; i < list.size(); i++) {
			// System.out.println("ind " + i + ", last index " + list.size());
			if (i == (list.size() - 1)) {
				System.out.println(list.get(i));
			} else {
				System.out.print(list.get(i) + " , ");
			}

		}
		long startR = System.nanoTime();
		String squares = sqInRectRecur(length, width);
		long endR = System.nanoTime();
		System.out.println("\nTime taken to execute recursive method was " + (endR - startR) / 1000.000 + "\u03BCs.");
		System.out.println(squares.substring(0, squares.length() - 2));

	}

}
