package gomoky.impl;

import javax.swing.JLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gomoky.CellValue;
import gomoky.HumanTurn;



public class DefaultHumanTurn implements HumanTurn{
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHumanTurn.class);
	public void makeHumanTurn(int i, int j, JLabel cells[][]) {
		DefaultGameTable.gameTable[i][j] = CellValue.HUMAN.getCell();
		LOGGER.info("Human turn is {}",DefaultGameTable.gameTable);
		cells[i][j].setText(String.valueOf(DefaultGameTable.gameTable[i][j]));
	}
}
