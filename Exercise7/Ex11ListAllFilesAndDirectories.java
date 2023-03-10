package Files;

import java.io.File;

public class Ex11ListAllFilesAndDirectories {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path="/Users/shivania/eclipse-workspace/OopsConcepts/src";
		File fileObject = new File(path);

		File fileArray[] = fileObject.listFiles();

		if (fileObject.exists() && fileObject.isDirectory()) {
			printDirectoryList(fileArray);
		}
		else {
			System.out.println("Empty directory");
		}
	}

	public static void printDirectoryList(File fileArray[]) {
		
		System.out.println("Directory list: ");
		System.out.println();

		for (int i = 0; i < fileArray.length; i++) {
			
			if (fileArray[i].isFile()) {
				System.out.println(fileArray[i].getName());
			} 
			else if (fileArray[i].isDirectory()) {
				System.out.println(fileArray[i].getName());
				File fileDirectory[] = fileArray[i].listFiles();
				for (int j = 0; j < fileDirectory.length; j++) {
					System.out.println("\t" + fileDirectory[j].getName());
				}
			}
			
		}
		
	}

}
