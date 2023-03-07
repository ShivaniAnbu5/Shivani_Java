package Files.Ex12;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex12CopyImageUsingByteByByteCopy {

	public static void main(String[] args) {

		String imagePath = "/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex12/image.png";
		try {
			FileInputStream fileInputStream = new FileInputStream(imagePath);
			FileOutputStream fileOutputStream = new FileOutputStream(
					"/Users/shivania/eclipse-workspace/EventHandlingAndIOStreams/src/Files/Ex12/imageCopy.png");

			byte[] buffer = new byte[1024];
			int length;

			while ((length = fileInputStream.read(buffer)) != -1) {
				// writes the number of bytes equal to length to the output stream from an array starting from the position 0.
				fileOutputStream.write(buffer, 0, length);
			}

			fileInputStream.close();
			fileOutputStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
