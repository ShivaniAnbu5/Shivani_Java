package exercises;

import java.util.Scanner;

public class ex21_printNoOfDaysInMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter month and year(eg:June 2023) :");
		String str[] = s.nextLine().split(" ");
		System.out.print(str[0]+" "+str[1]+" has ");
		
		switch(str[0]) {
			case "January": 
			case "March": 
			case "May": 
			case "July":
			case "August": 
			case "October": 
			case "December":
				System.out.print("31 days");
				break;
				
			case "February":
				int year = Integer.valueOf(str[1]);
				if((year%4==0 && year%100!=0) || year%400==0)
					System.out.print("29 days");
				else System.out.print("28 days");
				break;
				
			case "April": 
			case "June": 
			case "September": 
			case "November":
				System.out.print("30 days");
				break;
		}
		
	}

}
