package testReg.test;

public class TestEnumRun {

	public static void main(String[] args) {
		System.out.println("TestEnum.New:::"+TestEnum.New);
		System.out.println("TestEnum.New.Eq(New):::"+(TestEnum.New.equals("New")));
		System.out.println("TestEnum.New.Eq(Old):::"+(TestEnum.New.equals("Old")));
		System.out.println("TestEnum.Old.Eq(Old):::"+(TestEnum.Old.equals("Old")));
	}

}
