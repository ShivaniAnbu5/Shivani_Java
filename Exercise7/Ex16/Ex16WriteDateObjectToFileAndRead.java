package Files.Ex16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Ex16WriteDateObjectToFileAndRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();

		File destinationFile = new File(
				"Ex16ObjectFile.bin");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(date);
			System.out.println("Date object successfully written to file!");

			FileInputStream fileInputStream = new FileInputStream(destinationFile);

			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			Date dateObject = (Date) objectInputStream.readObject();

			System.out.println(dateObject);
			System.out.println("Date object successfully read from file!");

			fileOutputStream.close();
			objectOutputStream.close();
			fileInputStream.close();
			objectInputStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
