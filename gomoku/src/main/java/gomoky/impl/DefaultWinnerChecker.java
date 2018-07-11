package gomoky.impl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import gomoky.CellValue;
import gomoky.WinnerChecker;



public class DefaultWinnerChecker implements WinnerChecker {

	@Override
	public char findWinner(JLabel[][] cells) {
		if (findWinnerRow(cells)) {
			return DefaultConstants.ch;
		}
		if (findWinnerColumn(cells)) {
			return DefaultConstants.ch;
		}
		if (findWinnerDiagonalFirst(cells)) {
			return DefaultConstants.ch;
		}
		if (findWinnerDiagonalSecond(cells)) {
			return DefaultConstants.ch;
		}
		return DefaultConstants.NO_WINNER;
	}
	
	public static boolean findWinnerRow(JLabel cells[][]) {
		int count = 0;
		for (int i = 0; i < DefaultConstants.SIZE; i++) {
			for (int j = 0; j < DefaultConstants.SIZE; j++) {
				if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
					count = 0;
				}
				if (DefaultGameTable.gameTable[i][j] != CellValue.EMPTY.getCell()) {
					if (DefaultGameTable.gameTable[i][j] != DefaultConstants.ch) {
						DefaultConstants.ch = DefaultGameTable.gameTable[i][j];
						count = 1;
						DefaultConstants.winCells[count - 1][0] = i;
						DefaultConstants.winCells[count - 1][1] = j;
					} else {
						count++;
						DefaultConstants.winCells[count - 1][0] = i;
						DefaultConstants.winCells[count - 1][1] = j;
						if (count == 5) {
							for (int k = 0; k < 5; k++) {
								int row = DefaultConstants.winCells[k][0];
								int col = DefaultConstants.winCells[k][1];
								cells[row][col].setForeground(Color.RED);
								cells[row][col].setFont(new Font(Font.SERIF, Font.BOLD, 35));
							}
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static boolean findWinnerColumn(JLabel cells[][]) {
		int count = 0;
		for (int j = 0; j < DefaultConstants.SIZE; j++) {
			for (int i = 0; i < DefaultConstants.SIZE; i++) {

				if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
					count = 0;
				}
				if (DefaultGameTable.gameTable[i][j] != CellValue.EMPTY.getCell()) {
					if (DefaultGameTable.gameTable[i][j] != DefaultConstants.ch) {
						DefaultConstants.ch = DefaultGameTable.gameTable[i][j];
						count = 1;
						DefaultConstants.winCells[count - 1][0] = i;
						DefaultConstants.winCells[count - 1][1] = j;
					} else {
						count++;
						DefaultConstants.winCells[count - 1][0] = i;
						DefaultConstants.winCells[count - 1][1] = j;
						if (count == 5) {
							for (int k = 0; k < 5; k++) {
								int row = DefaultConstants.winCells[k][0];
								int col = DefaultConstants.winCells[k][1];
								cells[row][col].setForeground(Color.RED);
								cells[row][col].setFont(new Font(Font.SERIF, Font.BOLD, 35));
							}
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static boolean findWinnerDiagonalFirst(JLabel cells[][]) {
		int i0 = 0;
		int i1 = 4;
		int j0 = 10;
		int j1 = 14;
		int count = 0;
		for (int h = 0; h < 21; h++) {
			for (int i = i0, j = j0; i <= i1 && j <= j1; i++, j++) {
				if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
					count = 0;
				}
				if (DefaultGameTable.gameTable[i][j] != CellValue.EMPTY.getCell()) {
					if (DefaultGameTable.gameTable[i][j] != DefaultConstants.ch) {
						DefaultConstants.ch = DefaultGameTable.gameTable[i][j];
						count = 1;
						DefaultConstants.winCells[count - 1][0] = i;
						DefaultConstants.winCells[count - 1][1] = j;
					} else {
						count++;
						DefaultConstants.winCells[count - 1][0] = i;
						DefaultConstants.winCells[count - 1][1] = j;
						if (count == 5) {
							for (int k = 0; k < 5; k++) {
								int row = DefaultConstants.winCells[k][0];
								int col = DefaultConstants.winCells[k][1];
								cells[row][col].setForeground(Color.RED);
								cells[row][col].setFont(new Font(Font.SERIF, Font.BOLD, 35));
							}
							return true;
						}
					}
				}

			}
			if (j0 > 0) {
				j0--;
				i1++;
			} else {
				i0++;
				j1--;
			}
		}
		return false;
	}

	public static boolean findWinnerDiagonalSecond(JLabel cells[][]) {
		int i0 = 0;
		int i1 = 4;
		int j0 = 4;
		int j1 = 0;
		int count = 0;
		for (int h = 0; h < 21; h++) {
			for (int i = i0, j = j0; i <= i1 && j >= j1; i++, j--) {
				if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
					count = 0;
				}
				if (DefaultGameTable.gameTable[i][j] != CellValue.EMPTY.getCell()) {
					if (DefaultGameTable.gameTable[i][j] != DefaultConstants.ch) {
						DefaultConstants.ch = DefaultGameTable.gameTable[i][j];
						count = 1;
						DefaultConstants.winCells[count - 1][0] = i;
						DefaultConstants.winCells[count - 1][1] = j;
					} else {
						count++;
						DefaultConstants.winCells[count - 1][0] = i;
						DefaultConstants.winCells[count - 1][1] = j;
						if (count == 5) {
							for (int k = 0; k < 5; k++) {
								int row = DefaultConstants.winCells[k][0];
								int col = DefaultConstants.winCells[k][1];
								cells[row][col].setForeground(Color.RED);
								cells[row][col].setFont(new Font(Font.SERIF, Font.BOLD, 35));
							}
							return true;
						}
					}
				}

			}
			if (j0 < 14) {
				j0++;
				i1++;
			} else {
				i0++;
				j1++;
			}
		}
		return false;
	}
	
}
