package exercises;

import java.util.Scanner;

public class ex4_CreateOwnException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a age:");
		int age = s.nextInt();
		ex4_CreateOwnException ce = new ex4_CreateOwnException();
		try {
			ce.validateIfString(age);
		}
		catch(MyException me) {
			System.out.println("Exception caught!!!");
//			System.out.println(me.getMessage());
		}

		
	}
	
	void validateIfString(int age) throws MyException{
		if(age<18)
			throw new MyException("Invalid age for voting");
		else
			System.out.println("Valid age");
	}

}

class MyException extends Exception{
	public MyException(String exceptionMsg) {
		// TODO Auto-generated constructor stub
		super(exceptionMsg);
		System.out.println(exceptionMsg);
	}
}