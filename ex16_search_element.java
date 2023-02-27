package exercises;

import java.util.Scanner;

public class ex16_search_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = {4,3,6,2,4,8,9,4,10};
		//int arr[] = new int[n];
//		for(int i=0;i<n;i++) {
//			arr[i] = s.nextInt();
//		}
		int count=0;
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i] == n) 
				{
				System.out.print(i+" ");
				count++;
				}
			
		}
		if(count!=0)
		System.out.println("\n"+n+" occurs "+count+" times");
		else
			System.out.println("Not found");
	}

}
