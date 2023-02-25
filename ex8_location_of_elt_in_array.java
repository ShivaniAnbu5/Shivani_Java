package exercises;

import java.util.Scanner;

public class ex8_location_of_elt_in_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		System.out.println("Enter a num to find its location: ");
		int findNumLocation = s.nextInt();
		
		for(int i=0;i<n;i++) {
			if(arr[i] == findNumLocation) {
				System.out.println("Number present at index "+i);
				break;
			}
		}
	}

}
