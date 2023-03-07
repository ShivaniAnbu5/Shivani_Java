package Files.Ex15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex15CopyFIleLineByLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sourceFile = "/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex10/RenamedDemoFile.txt";

		try {
			FileReader fileReader = new FileReader(sourceFile);

			// It is used to read the text from a character-based input stream.It makes the
			// performance fast.
			// It uses buffering to enable large reads at a time for efficiency, storing
			// what is not needed immediately in memory for later use
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			FileWriter fileWriter = new FileWriter("/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex15/Ex15CopyFile.txt");

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				fileWriter.write(line+"\n");
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
