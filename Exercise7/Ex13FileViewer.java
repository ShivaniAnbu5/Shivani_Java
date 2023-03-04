package Files;

import java.io.FileReader;

public class Ex13FileViewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex10/RenamedDemoFile.txt";
		try {
			//Used to read data from the file.It returns data in byte format 
			//It gets filename in string. It opens the given file in read mode. 
			FileReader fileReader = new FileReader(file);
			int i;
			while((i=fileReader.read())!= -1) {
				System.out.println((char)i);
			}
			fileReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
