package Files.Ex14;

import java.io.FileReader;
import java.io.FileWriter;

public class Ex14FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sourceFile = "/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex10/RenamedDemoFile.txt";
		
		try {
			// Opens the file in that destination in read mode ad reads it
			FileReader fileReader = new FileReader(sourceFile);

			// It will create a new file if it doesn't exist already or else opens the
			// existing one
			FileWriter fileWriter = new FileWriter("/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex14/Ex14CopyFile.txt");

			int i;
			while ((i = fileReader.read()) != -1) {
				fileWriter.write((char) i);
			}

			// Closes the stream and then releases the resources that were used in this
			// stream
			fileReader.close();
			fileWriter.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
