package gomoky;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gomoky.CellValue;

public class CellValueTest {
	
	@Test
	public void testGetCell(){
		assertEquals('O', CellValue.COMPUTER.getCell());
		assertEquals('X',CellValue.HUMAN.getCell());
		assertEquals(' ', CellValue.EMPTY.getCell());
	}
	@Test
	public void testGetValue(){
		assertEquals("O", CellValue.COMPUTER.getValue());
		assertEquals("X",CellValue.HUMAN.getValue());
		assertEquals(" ", CellValue.EMPTY.getValue());
	}

}
