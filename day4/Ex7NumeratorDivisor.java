package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex7NumeratorDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Ex7NumeratorDivisor obj = new Ex7NumeratorDivisor();
		String numerator,denominator;
		int actualNumerator,actualDenominator;
		
		while(true){
			System.out.println("Enter the numerator and denominator:");
			try {
				numerator = s.next();
				char checkingVariable = obj.checkIfChar(numerator.charAt(0));
				
				if(checkingVariable == 'q') {
					System.exit(0);
				}
				else if(checkingVariable == 'a')
				{
					continue;
				}
				else {
				actualNumerator = Integer.parseInt(numerator);
				denominator = s.next();
				checkingVariable = denominator.charAt(0);
				if(checkingVariable>'a' && checkingVariable<'z')
				{
					System.out.println("Enter a valid number!!");
					continue;
				}
				
				actualDenominator = Integer.parseInt(denominator);
				obj.calculateResult(actualNumerator, actualDenominator);
				}
			}
			catch(InputMismatchException ipe) {
				System.out.println("Enter a valid number!!");
				continue;
			}
			catch(NumberFormatException ne) {
				continue;
			}
			
			
		}
	}
	
	char checkIfChar(char character) {
		// TODO Auto-generated method stub
		if(character == 'q' || character == 'Q')
			{
				return 'q';
			}
		else if(character>'a' && character<'z'){
			System.out.println("Please enter an integer!!!");
			return 'a';
		}
		else {
			return 'c';
		}
				
	}

	void calculateResult(int numerator,int denominator) throws ArithmeticException{
		try {
		System.out.println(numerator/denominator);
		}
		catch(Exception ae) {
			System.out.println("You cannot divide by zero.Please enter a number greater than 0!!!");
		}
	}
	


}
