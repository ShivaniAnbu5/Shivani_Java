package exercises;

public class ex22_accessDiffMembersAndMethodsOutsideClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modifiers modifiers = new Modifiers();
		modifiers.square();
		modifiers.printString();
		
		//Method not visible
//		modifiers.changePwd();
		
		modifiers.printAsDouble();
	}

}

class Modifiers{
	public int integer = 5;
	protected String str = "Hello World";
	private String pwd = "mySirius";
	float floatNum=5.6f;
	
	public void square() {
		System.out.println(integer*integer); 
	}
	
	protected void printString() {
		System.out.println(str);
	}
	
	private void changePwd() {
		pwd = "siriusPwd";
		System.out.println(pwd);
	}
	
	void printAsDouble() {
		System.out.println((double)floatNum);
	}
}
