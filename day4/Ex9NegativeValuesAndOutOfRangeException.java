package exercises;

import java.util.Scanner;

public class Ex9NegativeValuesAndOutOfRangeException {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	
		String number;
		int num,average=0,sum=0;
		System.out.println("Enter the marks for 10 students:");
		for(int i=0;i<10;i++) {
			System.out.println("Enter marks for student "+(i+1));
			number = s.nextLine();
			try {
				num=Integer.parseInt(number);
				if(num>100) throw new OutOfRangeException("Enter a value between 0 and 100!!");
				else if(num<0) throw new NegativeValueException("Enter a number greater than 0!!");
			}
			catch(OutOfRangeException oe) {
				System.out.println(oe.getMessage());
				i--;
				continue;
			}
			catch(NegativeValueException ne) {
				System.out.println(ne.getMessage());
				i--;
				continue;
			}
			catch(NumberFormatException ne) {
				System.out.println("Number Format Exception....Enter a valid number!!");
				i--;
				continue;
			}
			sum+=num;
			
	}
		average = sum/10;
		System.out.println("Average mark is "+average);
	}
}

class OutOfRangeException extends Exception{ 
	public OutOfRangeException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
}

class NegativeValueException extends Exception{
	public NegativeValueException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}