package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex8NumberFormatException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Ex7NumeratorDivisor obj = new Ex7NumeratorDivisor();
		String number;
		int num,average=0,sum=0;
		System.out.println("Enter the marks for 10 students:");
		for(int i=0;i<10;i++) {
			System.out.println("Enter marks for student "+(i+1));
			number = s.nextLine();
			try {
				num=Integer.parseInt(number);
				
			}
			catch(NumberFormatException ne) {
				System.out.println("NumberFormatException....Enter a valid number!!");
				i--;
				continue;
			}
			sum+=num;
			
	}
		average = sum/10;
		System.out.println("Average mark is "+average);

}

}