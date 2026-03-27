package com.mayank.create;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class UsingBufferOutputStream {

	public static void main(String[] args) {
//		File (Disk) → Buffer Memory → Program
//		Disk se ek baar me bahut data buffer me aa jata hai
//		Program buffer se read karta hai
//		Isliye disk access kam hota hai → speed fast ho jati hai.
		try {
			FileOutputStream fos = new FileOutputStream("src/test.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			String data = "Buffered OutputStream";

			bos.write(data.getBytes());

			bos.close();
			System.out.println("File Created.");
		} catch (Exception e) {
			System.out.println("Excception Occcur: " + e);
		}
	}

}
