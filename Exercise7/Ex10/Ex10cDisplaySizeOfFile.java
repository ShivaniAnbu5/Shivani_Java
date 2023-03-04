package Files.Ex10;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex10cDisplaySizeOfFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex10/RenamedDemoFile.txt";
		
		Path path = Paths.get(file);  
		try {
			System.out.println("Before writing to file: "+Files.size(path));
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Files demo in java");
			fileWriter.close();
			System.out.println("After writing to file: "+Files.size(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
