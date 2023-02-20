package exercises;

import java.util.Scanner;

public class ex15b_arms_perf_palin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number:");
		int n=s.nextInt();
		//153
		isArmstrong(n);
		isPerfect(n);
		isPalindrome(n);
		
	}
	
	static void isArmstrong(int n) {
		int temp=n,temp1=n;
		int digitCount = 0;
		while(temp>0) {
			digitCount++;
			temp/=10;
		}
		int sum=0;
		while(temp1>0) {
			int rem = temp1%10;
			int mul=rem;
			for(int i=1;i<digitCount;i++) 
			{
				mul *=rem;
			}
			sum+=mul;
			temp1/=10;
		}
		if(sum==n) System.out.println("Armstrong number");
		else System.out.println("Not an armstrong number");
		
	}
	
	static void isPerfect(int n) {
		int sum=0;
		for(int i=1;i<n;i++) {
			if(n%i==0) sum+=i;
		}
		if(sum == n) System.out.println("Perfect number");
		else System.out.println("Not a perfect number");
		
	}
	
	static void isPalindrome(int n) {
		int rev=0,temp=n;
		while(temp>0) {
			int rem = temp%10;
			rev = rev*10+rem;
			temp/=10;
		}
		if(rev == n) System.out.println("Palindrome");
		else System.out.println("Not a palindrome");
		
	}

}
