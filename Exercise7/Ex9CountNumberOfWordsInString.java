package Files;

import java.util.Scanner;

public class Ex9CountNumberOfWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter some text: ");
		String str = s.nextLine();
		System.out.println("Word:"+str+".");
		int wordCount = 0;
		boolean isWord = false;

		char charArray[] = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i])) {
				isWord = true;
			}
			else if (!Character.isLetter(charArray[i]) && isWord) {
				wordCount++;
				isWord = false;
			}
			if (Character.isLetter(charArray[i])
                    && i == str.length()-1) {
				wordCount++;
			}
               
		}
		System.out.println("Number of words: " + wordCount);
		s.close();
	}

}
