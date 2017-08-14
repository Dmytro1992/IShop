package gomoky.impl;

import javax.swing.JLabel;

import gomoky.CellValue;
import gomoky.ComputerTurn;



public class DefaultComputerTurn implements ComputerTurn {

	@Override
	public void makeComputerTurn(JLabel[][] cells) {
		if (compuretFourRow(cells)) {
			return;
		}
		if (compuretFourCol(cells)) {
			return;
		}
		if(computerFourSecondDiagonal(cells)){
			return;
		}
		if(computerFourFirstDiagonal(cells)){
			return;
		}
		if (compuretThreeRow(cells)) {
			return;
		}
		if (compuretThreeCol(cells)) {
			return;
		}
		if(computerThreeSecondDiagonal(cells)){
			return;
		}
		if(computerThreeFirstDiagonal(cells)){
			return;
		}
		if (compuretTwoRow(cells)) {
			return;
		}
		if (compuretTwoCol(cells)) {
			return;
		}
		if(compuretOneRow(cells)){
			return;
		}
		if(compuretOneCol(cells)){
			return;
		}
		
	}
	
	public static boolean compuretFourRow(JLabel cells[][]) {
		int countX = 0;
		int countO = 0;
		int countE = 0;
		int count = 0;
		for (int l = 0; l < DefaultConstants.SIZE; l++) {
			for (int j = 0; j < 11; j++) {
				for (int i = 0 + j; i < 5 + j; i++) {
					if (count > 4) {
						countX = 0;
						countE = 0;
						countO = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[l][i] == CellValue.HUMAN.getCell()) {
						countX++;
					} else if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
						countE++;
					}
					for (int q = 0; q < 5; q++) {
						if (countO == 4 && countE == 1) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
	
						}
						if (countX == 4 && countE == 1) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
						}
					}
					count++;
				}
			}
		}
		return false;
	}

	public static boolean compuretThreeRow(JLabel cells[][]) {
		int countX = 0;
		int countO = 0;
		int countE = 0;
		int count = 0;
		for (int l = 0; l < DefaultConstants.SIZE; l++) {
			for (int j = 0; j < 11; j++) {
				for (int i = 0 + j; i < 5 + j; i++) {
					if (count > 4) {
						countX = 0;
						countE = 0;
						countO = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[l][i] == CellValue.HUMAN.getCell()) {
						countX++;
					} else if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
						countE++;
					}

					for (int q = 0; q < 5; q++) {
						if (countO == 3 && countE == 2) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
						}
						if (countX == 3 && countE == 2) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
						}
					}
					count++;

				}
			}
			
		}
		return false;
	}

	public static boolean compuretTwoRow(JLabel cells[][]) {
		int countX = 0;
		int countO = 0;
		int countE = 0;
		int count = 0;
		for (int l = 0; l < DefaultConstants.SIZE; l++) {
			for (int j = 0; j < 11; j++) {
				for (int i = 0 + j; i < 5 + j; i++) {
					if (count > 4) {
						countX = 0;
						countE = 0;
						countO = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[l][i] == CellValue.HUMAN.getCell()) {
						countX++;
					} else if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
						countE++;
					}
					for (int q = 0; q < 5; q++) {
						if (countO == 2 && countE == 3) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
						} else if (countX == 2 && countE == 3) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
						}
					}
					count++;
				}
			}
		}
		return false;
	}
	
	public static boolean compuretOneRow(JLabel cells[][]) {
		int countX = 0;
		int countO = 0;
		int countE = 0;
		int count = 0;
		for (int l = 0; l < DefaultConstants.SIZE; l++) {
			for (int j = 0; j < 11; j++) {
				for (int i = 0 + j; i < 5 + j; i++) {
					if (count > 4) {
						countX = 0;
						countE = 0;
						countO = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[l][i] == CellValue.HUMAN.getCell()) {
						countX++;
					} else if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
						countE++;
					}
					for (int q = 0; q < 5; q++) {
						if (countO == 1 && countE == 4) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
						} else if (countX == 1 && countE == 4) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
						}
					}
					count++;
				}
			}
		}
		return false;
	}
	
	public static boolean compuretFourCol(JLabel cells[][]) {
		int countX = 0;
		int countO = 0;
		int countE = 0;
		int count = 0;
		for (int i = 0; i < DefaultConstants.SIZE; i++) {
			for (int j = 0; j < 11; j++) {
				for (int l = 0 + j; l < 5 + j; l++) {
					if (count > 4) {
						countX = 0;
						countE = 0;
						countO = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[l][i] == CellValue.HUMAN.getCell()) {
						countX++;
					} else if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
						countE++;
					}
					for (int q = 0; q < 5; q++) {
						if (countO == 4 && countE == 1) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
						}
						if (countX == 4 && countE == 1) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								i -= 1;
							}
						}
					}
					count++;
				}
			}
		}
		return false;
	}

	public static boolean compuretThreeCol(JLabel cells[][]) {
		int countX = 0;
		int countO = 0;
		int countE = 0;
		int count = 0;
		for (int i = 0; i < DefaultConstants.SIZE; i++) {
			for (int j = 0; j < 11; j++) {
				for (int l = 0 + j; l < 5 + j; l++) {
					if (count > 4) {
						countX = 0;
						countE = 0;
						countO = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[l][i] == CellValue.HUMAN.getCell()) {
						countX++;
					} else if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
						countE++;
					}

					for (int q = 0; q < 5; q++) {
						if (countO == 3 && countE == 2) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								l -= 1;
							}
						}
						if (countX == 3 && countE == 2) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								l -= 1;
							}
						}
					}
					count++;

				}
			}
			
		}
		return false;
	}

	public static boolean compuretTwoCol(JLabel cells[][]) {
		int countX = 0;
		int countO = 0;
		int countE = 0;
		int count = 0;
		for (int i = 0; i < DefaultConstants.SIZE; i++) {
			for (int j = 0; j < 11; j++) {
				for (int l = 0 + j; l < 5 + j; l++) {
					if (count > 4) {
						countX = 0;
						countE = 0;
						countO = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[l][i] == CellValue.HUMAN.getCell()) {
						countX++;
					} else if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
						countE++;
					}
					for (int q = 0; q < 5; q++) {
						if (countO == 2 && countE == 3) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								l -= 1;
							}
						} else if (countX == 2 && countE == 3) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								l -= 1;
							}
						}
					}
					count++;
				}
			}
		}
		return false;
	}
	
	public static boolean compuretOneCol(JLabel cells[][]) {
		int countX = 0;
		int countO = 0;
		int countE = 0;
		int count = 0;
		for (int i = 0; i < DefaultConstants.SIZE; i++) {
			for (int j = 0; j < 11; j++) {
				for (int l = 0 + j; l < 5 + j; l++) {
					if (count > 4) {
						countX = 0;
						countE = 0;
						countO = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[l][i] == CellValue.HUMAN.getCell()) {
						countX++;
					} else if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
						countE++;
					}
					for (int q = 0; q < 5; q++) {
						if (countO == 1 && countE == 4) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								l -= 1;
							}
						} else if (countX == 1 && countE == 4) {
							if (DefaultGameTable.gameTable[l][i] == CellValue.EMPTY.getCell()) {
								DefaultGameTable.gameTable[l][i] = CellValue.COMPUTER.getCell();
								cells[l][i].setText(String.valueOf(DefaultGameTable.gameTable[l][i]));
								return true;
							} else {
								l -= 1;
							}
						}
					}
					count++;
				}
			}
		}
		return false;
	}

	public static boolean computerFourSecondDiagonal(JLabel cells[][]) {
		int countO = 0;
		int countE = 0;
		int countX = 0;
		int count = 0;
		int i0 = 0;
		int i1 = 4;
		int j0 = 10;
		int j1 = 14;
		int q = 0;
		for (int h = 0; h < 21; h++) {
			for (int k = 0; k <= q; k++) {
				if (k == 0) {
					j1 -= q;
					i1 -= q;
				} else if (q >= 1) {
					j1++;
					i1++;
					j0++;
					i0++;
				}
				for (int i = i0, j = j0; i <= i1 && j <= j1; i++, j++) {
					if (count > 4) {
						countX = 0;
						countO = 0;
						countE = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[i][j] == CellValue.COMPUTER.getCell()) {
						countO++;
					} else if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
						countE++;
					}else if (DefaultGameTable.gameTable[i][j] == CellValue.HUMAN.getCell()) {
						countX++;
					}
					for(int a = 0; a < 5; a++){
					if (countO == 4 && countE == 1) {
						if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
							DefaultGameTable.gameTable[i][j] = CellValue.COMPUTER.getCell();
							cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
							return true;
						}else{
							i--;
							j--;
						}
						
					}
					 if (countX == 4 && countE == 1) {
						if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
							DefaultGameTable.gameTable[i][j] = CellValue.COMPUTER.getCell();
							cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
							return true;
						}else{
							i--;
							j--;
						}
					 }
					}
					
					count++;

				
				}
			}
			i0 -= q;
			j0 -= q;
			if (j0 > 0) {
				j0--;
				i1++;
				q++;
			} else {
				i0++;
				j1--;
				q--;
			}
		}
		return false;
	}
	
	public static boolean computerThreeSecondDiagonal(JLabel cells[][]) {
		int countO = 0;
		int countE = 0;
		int countX = 0;
		int count = 0;
		int i0 = 0;
		int i1 = 4;
		int j0 = 10;
		int j1 = 14;
		int q = 0;
		for (int h = 0; h < 21; h++) {
			for (int k = 0; k <= q; k++) {
				if (k == 0) {
					j1 -= q;
					i1 -= q;
				} else if (q >= 1) {
					j1++;
					i1++;
					j0++;
					i0++;
				}
				for (int i = i0, j = j0; i <= i1 && j <= j1; i++, j++) {
					if (count > 4) {
						countX = 0;
						countO = 0;
						countE = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[i][j] == CellValue.COMPUTER.getCell()) {
						countO++;
					} else if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
						countE++;
					}else if (DefaultGameTable.gameTable[i][j] == CellValue.HUMAN.getCell()) {
						countX++;
					}
					for(int a = 0; a < 5; a++){
					if (countO == 3 && countE == 2) {
						if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
							DefaultGameTable.gameTable[i][j] = CellValue.COMPUTER.getCell();
							cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
							return true;
						}else{
							i--;
							j--;
						}
						
					}
					 if (countX == 3 && countE == 2) {
						if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
							DefaultGameTable.gameTable[i][j] = CellValue.COMPUTER.getCell();
							cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
							return true;
						}else{
							i--;
							j--;
						}
					 }
					}
					
					count++;
				}
			}
			i0 -= q;
			j0 -= q;
			if (j0 > 0) {
				j0--;
				i1++;
				q++;
			} else {
				i0++;
				j1--;
				q--;
			}
		}
		return false;
	}
	
	public static boolean computerFourFirstDiagonal(JLabel cells[][]) {
		int countO = 0;
		int countE = 0;
		int countX = 0;
		int count = 0;
		int i0 = 0;
		int i1 = 4;
		int j0 = 4;
		int j1 = 0;
		int q = 0;
		for (int h = 0; h < 21; h++) {
			for (int k = 0; k <= q; k++) {
				if (k == 0) {
					j1 += q;
					i1 -= q;
				} else if (q >= 1) {
					j1--;
					i1++;
					j0--;
					i0++;
				}
				for (int i = i0, j = j0; i <= i1 && j >= j1; i++, j--) {
					if (count > 4) {
						countO = 0;
						countE = 0;
						countX = 0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[i][j] == CellValue.COMPUTER.getCell()) {
						countO++;
					} else if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
						countE++;
					}else if (DefaultGameTable.gameTable[i][j] == CellValue.HUMAN.getCell()) {
						countX++;
					}
					for(int a = 0; a < 5; a++){
					if (countO == 4 && countE == 1) {
						if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
							DefaultGameTable.gameTable[i][j] = CellValue.COMPUTER.getCell();
							cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
							return true;
						}else{
							i--;
							j++;
						}
					}
					
					if (countX == 4 && countE == 1) {
						if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
							DefaultGameTable.gameTable[i][j] = CellValue.COMPUTER.getCell();
							cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
							return true;
						}else{
							i--;
							j++;
						}
					}
					}
					count++;

				}
			}
			i0 -= q;
			j0 += q;
			if (j0 < 14) {
				i1++;
				j0++;
				q++;
			} else {
				i0++;
				j1++;
				q--;
			}
		}
		return false;
	}
	
	public static boolean computerThreeFirstDiagonal(JLabel cells[][]) {
		int countO = 0;
		int countE = 0;
		int countX=0;
		int count = 0;
		int i0 = 0;
		int i1 = 4;
		int j0 = 4;
		int j1 = 0;
		int q = 0;
		for (int h = 0; h < 21; h++) {
			for (int k = 0; k <= q; k++) {
				if (k == 0) {
					j1 += q;
					i1 -= q;
				} else if (q >= 1) {
					j1--;
					i1++;
					j0--;
					i0++;
				}
				for (int i = i0, j = j0; i <= i1 && j >= j1; i++, j--) {
					if (count > 4) {
						countO = 0;
						countE = 0;
						countX=0;
						count = 0;
					}
					if (DefaultGameTable.gameTable[i][j] == CellValue.COMPUTER.getCell()) {
						countO++;
					} else if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
						countE++;
					}else if (DefaultGameTable.gameTable[i][j] == CellValue.HUMAN.getCell()) {
						countX++;
					}
					if (countO == 3 && countE == 2) {
						if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
							DefaultGameTable.gameTable[i][j] = CellValue.COMPUTER.getCell();
							cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
							return true;
						}else{
							i--;
							j++;
						}
					}
					if (countX == 3 && countE == 2) {
						if (DefaultGameTable.gameTable[i][j] == CellValue.EMPTY.getCell()) {
							DefaultGameTable.gameTable[i][j] = CellValue.COMPUTER.getCell();
							cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
							return true;
						}else{
							i--;
							j++;
						}
					}
					count++;

				}
			}
			i0 -= q;
			j0 += q;
			if (j0 < 14) {
				i1++;
				j0++;
				q++;
			} else {
				i0++;
				j1++;
				q--;
			}
		}
		return false;
	}

}
