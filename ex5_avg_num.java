package exercises;

import java.util.Scanner;

public class ex5_avg_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		float avg = print_avg(arr,n);
		System.out.println("Average is "+avg);
	}
	
	static float print_avg(int a[],int size) {
		float avg=0;
		for(int i=0;i<size;i++) {
			avg+=a[i];
		}
		avg/=size;
		return avg;
		
	}

}
