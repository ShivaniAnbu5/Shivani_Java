package exercises;

import java.util.Scanner;

public class ex5_Modify4thEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ex5_Modify4thEx obj = new ex5_Modify4thEx();
		int age = s.nextInt();
		
		//Unhandled exception
		obj.checkAge(age);

	}

	  void checkAge(int age) throws MyException{
		// TODO Auto-generated method stub
		  if(age<18)
				throw new MyException("Invalid age for voting");
			else
				System.out.println("Valid age");
		
	}

}
