package Files;
import java.util.Scanner;
public class Ex8CountCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int countOfCharacters = 0;
		while(true) {
			System.out.println("Enter a character: ");
			scanner.next().charAt(0);
			countOfCharacters++;
			System.out.println(countOfCharacters);	
		}	
	}
}
