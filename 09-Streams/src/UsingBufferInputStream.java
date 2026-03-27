import java.io.*;

public class UsingBufferInputStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/test.txt");

	        BufferedInputStream bis = new BufferedInputStream(fis);

	        int data;

	        while((data = bis.read()) != -1){
	            System.out.print((char)data);
	        }

	        bis.close();
		} catch (Exception e) {
			System.out.println("Exception Occur: " + e);
		}
	}

}
