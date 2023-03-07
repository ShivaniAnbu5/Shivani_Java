package Files;

import java.io.IOException;
import java.util.Scanner;

public class Ex8CountCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int countCharacters = 0;
		while(true) {
			System.out.println("Enter a character: ");
			char character = s.next().charAt(0);
			countCharacters++;
			System.out.println(countCharacters);
			
		}
		
		
	}

}
