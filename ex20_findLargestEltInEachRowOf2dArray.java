package exercises;

import java.util.Scanner;

public class ex20_findLargestEltInEachRowOf2dArray {

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
//		int arr[][] =new int[][]{{5,6,798768,8},{8,9,2,3},{9,8,0,2}};
		for(int i=0;i<arr.length;i++) {
			int max=0;
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j] > max) max = arr[i][j];
			}
			System.out.println("Largest element in row "+i+" is "+max);
		}
	}

}
