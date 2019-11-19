package com.problems.CodeWarsSolutions;

import java.util.ArrayList;
import java.util.Arrays;

public class StringMerger {
	public static boolean isMerge(String s, String part1, String part2) {
		String copyS = s;
		ArrayList<String> checker = new ArrayList<String>(Arrays.asList(copyS.split("")));

		for (String str : checker) {
			System.out.println(str);
		}

		ArrayList<String> reducePart1 = reduceList(checker, part1);
		ArrayList<String> result = reduceList(reducePart1, part2);
		for (String el : result) {
			System.out.println("element is " + el);
		}
		return (result.isEmpty()) ? true : false;
	}

	private static ArrayList<String> reduceList(ArrayList<String> list, String reduceBy) {
		for (int i = 1; i < reduceBy.length(); i++) {
			int currIndex = list.indexOf(reduceBy.substring(i, i + 1));
			int prevIndex = list.indexOf(reduceBy.substring(i - 1, i));
			if (currIndex > prevIndex) {
				System.out.println("index to be removed is " + prevIndex);
				list.remove(prevIndex);
				if (i == (reduceBy.length() - 1)) {
					currIndex = list.indexOf(reduceBy.substring(i));
					System.out.println("index to be removed is " + currIndex);
					list.remove(currIndex);
				}
				continue;
			} else {
				return list;
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// System.out.println(isMerge("codeWars", "cdWrs", "oea"));
		System.out.println(isMerge("", "", ""));
	}

}
