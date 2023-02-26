package exercises;

import java.util.Scanner;

public class Ex8NumberFormatException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String number;
		int num,average=0,sum=0;
		System.out.println("Enter the marks for 10 students:");
		int studentCount = 0;
		while(studentCount != 10) {
			System.out.println("Enter marks for student "+(studentCount+1)+":");
			number = s.nextLine();
			try {
				num=Integer.parseInt(number);
				studentCount++;
				
			}
			catch(NumberFormatException ne) {
				System.out.println("NumberFormatException....Enter a valid number!!");
				continue;
			}
			sum+=num;
		}
		average = sum/10;
		System.out.println("Average mark is "+average); 

}

}
