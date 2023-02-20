package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ex6_resize_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		System.out.println("Size to resize to: ");
		
		int resize = s.nextInt();
		int newArray[] = new int[resize];
		int size=0;
		if(resize < n) size = resize; else size =n;
		for(int i=0;i<size;i++) {
			newArray[i] = arr[i];
		}
//		int newArray[] = Arrays.copyOf(arr, resize);
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
//		System.out.println("New array is "+Arrays.toString(newArray));
	}

}
