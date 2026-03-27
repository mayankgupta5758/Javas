import java.io.FileInputStream;

public class UsingFileInputStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/test.txt");

			int data;

			while ((data = fis.read()) != -1) {
				System.out.print((char) data);
			}

			fis.close();
		} catch (Exception e) {
			System.out.println("Exception Occur: " + e);
		}
	}

}
