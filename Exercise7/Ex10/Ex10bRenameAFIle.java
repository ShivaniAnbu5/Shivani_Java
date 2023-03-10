package Files.Ex10;

import java.io.File;
import java.io.IOException;

public class Ex10bRenameAFIle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("RenameDemoFile.txt");
		try {
			boolean isFileCreated = file.createNewFile();
			if (isFileCreated == true) {
				System.out.println("File created");
			}
			else {
				System.out.println("Already exists");
			}
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

		String file1Name = "RenamedDemoFile.txt";
		File file1 = new File(file1Name);
		boolean isFileRenamed = file.renameTo(file1);
		if (isFileRenamed) {
			System.out.println("File renamed");
		}
		else {
			System.out.println("File not renamed");
		}
		
	}
}
