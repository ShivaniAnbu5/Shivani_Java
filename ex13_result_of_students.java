package exercises;

import java.util.Scanner;

public class ex13_result_of_students {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no. of students:");
		int m=s.nextInt();
		System.out.println("Enter number of subjects");
		int n=s.nextInt();
		int arr[][]= new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		int result_array[] = new int[m];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				result_array[i]+=arr[i][j];
			}
		}
		
		for(int i=0;i<result_array.length;i++)
			System.out.print(result_array[i]+" ");
	}

}
