package gomoky.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gomoky.impl.DefaultConstants;

public class DefaultConstantsTest {
	int[][]w = new int [5][2];
	@Test
	public void testDefaultConstants(){
		assertEquals(w,DefaultConstants.winCells);
		assertEquals(0, DefaultConstants.ch);
		assertEquals(15, DefaultConstants.SIZE);
		assertEquals(0, DefaultConstants.NO_WINNER);
	}

}
