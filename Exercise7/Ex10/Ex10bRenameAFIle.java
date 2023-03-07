package Files.Ex10;

import java.io.File;
import java.io.IOException;

public class Ex10bRenameAFIle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// This is just an abstract representation of a file
		// A new file is not created
		File file = new File("/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex10/RenameDemoFile.txt");
		try {
			boolean fileCreated = file.createNewFile();
			if (fileCreated)
				System.out.println("File created");
			else
				System.out.println("Already exists");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String file1Name = "/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex10/RenamedDemoFile.txt";
		File file1 = new File(file1Name);
		boolean renameFile = file.renameTo(file1);
		if (renameFile)
			System.out.println("File renamed");
		else
			System.out.println("File not renamed");

	}

}
