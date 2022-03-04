package testReg.test;

public enum TestEnum {

	New("New", 0),
	Old("Old", 0);
	
	private final String name;
	private final int no;
	
	private TestEnum (String name, int no) {
		this.name = name;
		this.no = no;
	}
	
	public String toString() {
		return name;
	}
	public int no() {
		return no;
	}
}
