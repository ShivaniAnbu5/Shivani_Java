package Multithreading;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EX6TotalOfAllCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Characters c = new Characters();
		Scanner s = new Scanner(System.in);
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(true) {
			System.out.println("Enter a character:");
			try {
			char character = s.next().charAt(0);
			if(character>='a' && character<='z' || character>='A' && character<='Z')
				c.printCharacter(character);
			else throw new NonAlphabeticCharacterException();
			}catch(NonAlphabeticCharacterException nace) {
				System.out.println(nace);
			}
			}
			
		});
		s.close();
	}

}

class Characters{
	int charCount;
	void printCharacter(char c) {
		charCount++;
		System.out.println(c);
		System.out.println("Character count: "+charCount);
	}
}

class NonAlphabeticCharacterException extends Exception{

	@Override
	public String toString() {
		return "Enter an alphabet!!!";
	}
	
}

