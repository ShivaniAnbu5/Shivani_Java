package exercises;

import java.util.Scanner;

public class ex19_reverseEltsInRowOf2dArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int m=s.nextInt(),n=s.nextInt();
//		int arr[][] =new int[][]{{5,6,7,8},{8,9,2,3},{9,8,0,2}};
		int arr[][] =new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length/2;j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[0].length-1-j];
				arr[i][arr[0].length-1-j] = temp;
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
