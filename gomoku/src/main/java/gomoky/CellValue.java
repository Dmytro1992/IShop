package gomoky;

public enum CellValue {
	HUMAN ('X'),
	
	COMPUTER('O'),
	
	EMPTY(' ');
	
	private char value;
	
	private CellValue (char value){
		this.value = value;
	}
	
	public char getCell (){
		return value;
	}
	
	public String getValue(){
		return String.valueOf(value);
	}
	
}
