package com.mayank.write;

import java.io.*;

public class UsingBufferOutputStream {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("src/test.txt", true);

			BufferedOutputStream bos = new BufferedOutputStream(fos);

			String data = "\nHello Java using BufferedOutputStream";

			bos.write(data.getBytes());

			bos.close();

			System.out.println("Data written successfully");
		} catch (Exception e) {
			System.out.println("Excception Occcur: " + e);
		}
	}

}
