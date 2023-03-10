package Files.Ex10;

import java.io.File;

public class Ex10aDeleteAFile {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		File file = new File("DeleteDemoFile.txt");
		try {
			file.createNewFile();
			System.out.println("File created");
			Thread.sleep(5000);
			if (file.delete()) {
				System.out.println("File deleted");
			}
			else {
				System.out.println("File not deleted");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
