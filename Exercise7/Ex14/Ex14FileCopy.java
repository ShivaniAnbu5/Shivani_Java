package Files.Ex14;

import java.io.FileReader;
import java.io.FileWriter;

public class Ex14FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sourceFile = "RenamedDemoFile.txt";
		
		try {
			FileReader fileReader = new FileReader(sourceFile);

			FileWriter fileWriter = new FileWriter("Ex14CopyFile.txt");

			int asciiValue;
			while ((asciiValue = fileReader.read()) != -1) {
				fileWriter.write((char) asciiValue);
			}

			fileReader.close();
			fileWriter.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
