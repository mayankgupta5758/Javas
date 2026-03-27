package com.mayank.delete;

import java.io.File;

public class UsingFile {

	public static void main(String[] args) {
        File file = new File("src/test.txt");

        if(file.exists()){
            file.delete();
            System.out.println("File deleted");
        }else{
            System.out.println("File does not exist");
        }
	}

}
