package exercises;

import java.util.Scanner;

public class ex11_display_as_matrix_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter dimensions of array:");
		int m=s.nextInt();
		int n=s.nextInt();
		int arr[][]= new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		int in1=0,in2=0;
		for(int i=0;i<m;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print(arr[in1][in2++]+" ");
//					System.out.println("in1 is "+in1+" in2 is "+in2);
					if(in2 == n) { in1++; in2=0;}
//					System.out.println("in1 is "+in1+" in2 is "+in2);
				}
			
			System.out.println();
		}
	}

}
