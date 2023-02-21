package exercises;

public class ex6_CheckDerivedClassConst {
	public ex6_CheckDerivedClassConst() throws MyException{
		System.out.println("Parent class throws MyException");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Subclass extends ex6_CheckDerivedClassConst{

	public Subclass() throws MyException {
		
		// TODO Auto-generated constructor stub
		super();
//		This won't work since the method or the constructor throwing the exception is not called inside the try block
//		So it's not possible for derived class constructor to catch an exception thrown by the parent class constructor
//		try {
//			
//		}
//		catch(MyException me) {
//			System.out.println("Caught exception from base class");
//		}
	}
	
}