package exercises;

import java.io.FileReader;

public class ex1_ThrowIOException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fileReader = new FileReader("file.txt");
		System.out.println(fileReader.read());
		fileReader.close();
		
		
	}
	


}
