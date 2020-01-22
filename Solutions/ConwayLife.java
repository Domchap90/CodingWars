package com.problems.CodeWarsSolutions;

public class ConwayLife {
	public static int[][] getGeneration(int[][] cells, int generations) {
		// determine If alive or dead: 1 or 0.
		// 1: 2 or 3 live neighbours survive else dead
		// 0: exactly 3 live neighbours -> changes to 1. else stay 0
		int[][] newCells = new int[cells.length][cells[0].length];
		int colnum = cells[0].length;
		int rownum = cells.length;
		int cycles = 0;
		if (generations == 0) {
			newCells=cells;
		}
		while (cycles < generations) {
			for (int r = 0; r < rownum; r++) {
				for (int c = 0; c < colnum; c++) {
					if (cells[r][c] == 1) {
						if (MooreNeighborSum(cells, r, c) == 2 || MooreNeighborSum(cells, r, c) == 3) {
							newCells[r][c] = 1;
						} else {
							newCells[r][c] = 0;
						}
					} else {
						if (MooreNeighborSum(cells, r, c) == 3) {
							newCells[r][c] = 1;
						}
					}
				}
			}
			cycles++;
			cells = newCells.clone();
		}
		return newCells;

	}

	public static int MooreNeighborSum(int[][] cells, int row, int col) {
		int sum = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			inner:
			for (int j = col - 1; j <= col + 1; j++) {
				if (i < 0 || j < 0 || i > cells.length - 1 || j > cells[0].length - 1 || (i == row && j == col)) {
					continue inner;
				} else {
					sum += cells[i][j];
				}
			}
		}
		return sum;
	}

	public static String depictBinArray(int[][] cells) {
		String depict = "";
		for (int[] cell : cells) {
			for (int element : cell) {
				if (element == 0) {
					depict += ".";
				} else if (element == 1) {
					depict += "#";
				} else {
					System.out.println("Non binary digit entered.");
					break;
				}
			}
			depict += "\n";
		}
		depict += "\n";
		return depict;
	}

	public static void main(String[] args) {
		int[][] test1 = { { 1, 0, 0 }, { 0, 1, 1 }, { 1, 1, 0 } };

//		int[][] test2 = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 } };
		int [][]glider= { {1,0,0},{0,1,1},{1,1,0} };

//		System.out.println(depictBinArray(test1) + depictBinArray(getGeneration(test1, 1)));
		System.out.println("glider 0:\n" + depictBinArray(getGeneration(glider, 0)) + "glider 1:\n"
				+ depictBinArray(getGeneration(glider, 1)) + "glider 2:\n" + depictBinArray(getGeneration(glider, 2)));

		System.out.println("Sum of Neighbourhood at [1][1] is " + MooreNeighborSum(test1, 1, 1) + ".");
		System.out.println("Sum of Neighbourhood at [0][0] is " + MooreNeighborSum(test1, 0, 0) + ".");
		System.out.println("Sum of Neighbourhood at [1][2] is " + MooreNeighborSum(test1, 1, 2) + ".");

	}
}
