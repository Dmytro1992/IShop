package gomoky.impl;

import gomoky.CellValue;
import gomoky.GameTable;

public class DefaultGameTable implements GameTable{
	
	public static final  char[][] gameTable = new char[DefaultConstants.SIZE][DefaultConstants.SIZE];
	
	public boolean isCellFree(int i, int j) {
		return gameTable[i][j] == CellValue.EMPTY.getCell();
	}

	public static void init() {
		for (int i = 0; i < DefaultConstants.SIZE; i++) {
			for (int j = 0; j < DefaultConstants.SIZE; j++) {
				gameTable[i][j] = CellValue.EMPTY.getCell();
			}
		}
	}
}
