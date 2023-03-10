package Files;

import java.io.FileReader;

public class Ex13FileViewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "RenamedDemoFile.txt";
		try {
			FileReader fileReader = new FileReader(file);
			int asciiValue;
			while((asciiValue=fileReader.read())!= -1) {
				System.out.println((char)asciiValue);
			}
			fileReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
