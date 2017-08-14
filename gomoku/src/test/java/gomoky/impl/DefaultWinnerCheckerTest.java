package gomoky.impl;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gomoky.CellValue;
import gomoky.HumanTurn;
import gomoky.WinnerChecker;
import gomoky.impl.DefaultWinnerChecker;



public class DefaultWinnerCheckerTest {
	
	@Test
	public void testFindWinnerRow(){
		WinnerChecker winnerChecker;
		winnerChecker = new DefaultWinnerChecker();

		int i =1;
		int j = 3;
		JLabel [][]cells = null;
		assertEquals(false, winnerChecker.findWinner(cells));
		
	}

}
