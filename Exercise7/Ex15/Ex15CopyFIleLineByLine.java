package Files.Ex15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex15CopyFIleLineByLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sourceFile = "RenamedDemoFile.txt";

		try {
			FileReader fileReader = new FileReader(sourceFile);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			FileWriter fileWriter = new FileWriter("Ex15CopyFile.txt");

			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				fileWriter.write(line + "\n");
			}

			fileReader.close();
			fileWriter.close();
			bufferedReader.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
