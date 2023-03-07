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
				"/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex16/Ex16ObjectFile.txt");
		try {
			// FileOutputStream is an output stream used for writing data to a file.
			FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);

			// This encodes Java objects and generates corresponding streams.Those converted
			// streams can be stored in files and can be transferred among networks.
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(date);
			System.out.println("Date object successfully written to file!");

			// Java FileInputStream class obtains input bytes from a file. It is used for
			// reading byte-oriented data (streams of raw bytes)
			FileInputStream fileInputStream = new FileInputStream(destinationFile);

			// An ObjectInputStream deserializes objects previously written using an
			// ObjectOutputStream.
			// That is to convert an object's state into a byte stream and then converting
			// it back to its object state so that it can be sent over the network if needed
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			Date readDate = (Date) objectInputStream.readObject();

			System.out.println(readDate);
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
