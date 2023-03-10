package Files.Ex12;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex12CopyImageUsingByteByByteCopy {

	public static void main(String[] args) {

		String imagePath = "image.png";
		try {
			FileInputStream fileInputStream = new FileInputStream(imagePath);
			
			FileOutputStream fileOutputStream = new FileOutputStream(
					"imageCopy.png");

			byte[] buffer = new byte[1024];
			int length;

			while ((length = fileInputStream.read(buffer)) != -1) {
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
