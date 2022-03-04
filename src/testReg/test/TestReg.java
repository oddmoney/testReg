package testReg.test;

public class TestReg {

	public static void main(String[] args) {
	
		System.out.println("REG1:::"  +("FT/FT01010101010101".matches("^(FT)?/?(FT[A-Z0-9\\-\\_]{1,})$")));
		System.out.println("REGVAL:::"+("FTFT01010101010101".replaceAll("^(FT)?/?(FT[A-Z0-9\\-\\_]{1,})$", "$2")));
	}
	
	
	
	
}
