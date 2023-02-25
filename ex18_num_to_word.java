package exercises;

import java.util.Scanner;

public class ex18_num_to_word {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String arr[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int rev=0,temp=n;
		while(temp>0) {
			int rem = temp%10;
			rev = rev*10+rem;
			temp/=10;
		}
		while(rev>0) {
			int rem = rev%10;
			System.out.print(arr[rem]+" ");
			rev/=10;
		}
	}

}
