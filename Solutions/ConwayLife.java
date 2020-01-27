package com.problems.CodeWarsSolutions;

public class ConwayLife {
	public static int[][] getGeneration(int[][] cells, int generations) {
		// determine If alive or dead: 1 or 0.
		// 1: 2 or 3 live neighbours survive else dead
		// 0: exactly 3 live neighbours -> changes to 1. else stay 0
		int[][] newCells = new int[cells.length][cells[0].length];
		int cycles = 0;
		if (generations == 0) {
			newCells=cells;
		}
		while (cycles < generations) {
			cells = border(cells);
			newCells = border(newCells);
			for (int r = 0; r < cells.length; r++) {
				for (int c = 0; c < cells[0].length; c++) {
					if (cells[r][c] == 1) {
						if (MooreNeighborSum(cells, r, c) == 2 || MooreNeighborSum(cells, r, c) == 3) {
							newCells[r][c] = 1;
						} else {
							newCells[r][c] = 0;
						}
					} else {// consider outside border of dead cells! Move to
						if (MooreNeighborSum(cells, r, c) == 3) {
							newCells[r][c] = 1;
						}
					}

				}
			}
			int sumFRow = 0;
			int sumLRow = 0;
			int sumFCol = 0;
			int sumLCol = 0;
			int[][] endArr;
			while (sumFRow == 0) {
				for (int i = 0; i < newCells[0].length; i++) {// identify dead row
					sumFRow += newCells[0][i];
				}

				if (sumFRow == 0) {
					endArr = new int[newCells.length - 1][newCells[0].length];// same for LRow
					for (int i = 0; i < endArr.length; i++) {
						endArr[i] = newCells[i + 1].clone();
					}
					newCells = endArr.clone();
				}
			}
			while (sumLRow == 0) {
				for (int i = 0; i < newCells[newCells.length - 1].length; i++) {
					sumLRow += newCells[newCells.length - 1][i];
				}
				if (sumLRow == 0) {
					endArr = new int[newCells.length - 1][newCells[0].length];
					for (int i = 0; i < endArr.length; i++) {
						endArr[i] = newCells[i].clone();
					}
					newCells = endArr.clone();
				}
			}
			while (sumFCol == 0) {
			for (int[] newCell : newCells) {// first col
				sumFCol += newCell[0];
			}
			if (sumFCol == 0) {
				endArr = new int[newCells.length][newCells[0].length - 1];
				for (int i = 0; i < endArr.length; i++) {
					for (int j = 0; j < endArr[0].length; j++) {
						endArr[i][j] = newCells[i][j + 1];
					}
				}
				newCells = endArr.clone();
			}
			}
			while (sumLCol == 0) {
			for (int[] newCell : newCells) {// last col
				sumLCol += newCell[newCells[0].length-1];
			}
			if (sumLCol == 0) {
				endArr = new int[newCells.length][newCells[0].length - 1];
				for (int i = 0; i < endArr.length; i++) {
					for (int j = 0; j < endArr[0].length; j++) {
						endArr[i][j] = newCells[i][j];
					}
				}
				newCells = endArr.clone();
			}
			}
			cycles++;
			cells = newCells.clone();
		}
		return newCells;

	}

	// eliminate dead rows + cols
	public static int[][] border(int[][] cells) {
		int[][] borderArr = new int[cells.length + 2][cells[0].length + 2];
		for (int row = 0; row < borderArr.length; row++) {
			for (int col = 0; col < borderArr[0].length; col++) {
				if (row == 0 || col == 0 || row == borderArr.length - 1 || col == borderArr[0].length - 1) {
					borderArr[row][col] = 0;
				} else {
					borderArr[row][col] = cells[row - 1][col - 1];
				}
			}
		}
		return borderArr;
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

//		System.out.println(depictBinArray(test1) + depictBinArray(border(test1)));

		System.out.println("Sum of Neighbourhood at [1][1] is " + MooreNeighborSum(test1, 1, 1) + ".");
		System.out.println("Sum of Neighbourhood at [0][0] is " + MooreNeighborSum(test1, 0, 0) + ".");
		System.out.println("Sum of Neighbourhood at [1][2] is " + MooreNeighborSum(test1, 1, 2) + ".");

	}
}
