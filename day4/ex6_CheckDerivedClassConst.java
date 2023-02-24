package exercises;

public class ex6_CheckDerivedClassConst {
	public ex6_CheckDerivedClassConst() throws MyException{
		System.out.println("Parent class throws MyException");
		throw new MyException("ugu");
		
	}

	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub
		Subclass obj = new Subclass();

	}

}

class Subclass extends ex6_CheckDerivedClassConst{

	public Subclass() throws MyException {
		
		// TODO Auto-generated constructor stub
		super();
//		try {
//			
//		}
//		catch(MyException me) {
//			System.out.println(me.getMessage());
//		}
	}
	
}
