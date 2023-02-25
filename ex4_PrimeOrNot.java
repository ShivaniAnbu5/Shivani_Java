package exercises;

import java.util.Scanner;

public class ex4_PrimeOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		
		int count=0;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) 
				{
					count++;
					break;
				}
		}
		
		if(count==0)
			System.out.println("Prime number");
		else
			System.out.println("Not a prime number");
	}

}
