import java.io.*;

public class AboutException {
	public static void tryCatch() {
		try {
			int a = 10;
			int b = 0;
			int result = a / b;
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
		}
	}

	public static void tryCatchFinally() {
		try {
			int arr[] = new int[3];
			System.out.println(arr[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of bound");
		} finally {
			System.out.println("Program finished");
		}
	}

	public static void multipleCatch() {
		try {
			String str = null;
			System.out.println(str.length());
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Error");
		} catch (NullPointerException e) {
			System.out.println("Null Error");
		}
	}

	public static void throwExample() {
		int age = 15;

		if (age < 18) {
			throw new ArithmeticException("Not eligible to vote");
		}
	}

	public static void readFile() throws IOException {
		FileReader file = new FileReader("test.txt");
	}

	public static void main(String[] args) {
//		Exception Handling ka matlab hai program me aane wali errors (runtime errors) ko handle karna,
//		taaki program crash na ho aur properly chale.
		tryCatch();
		tryCatchFinally();
		multipleCatch();
		throwExample();
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("File not found");
		}

		/*
		 * Types of Exceptions in Java 🔹 1. Checked Exception Compile time pe check
		 * hoti hai Example: IOException, SQLException
		 * FileReader file = new FileReader("abc.txt");  // Compile-time error
		 * 
		 * 🔹 2. Unchecked Exception Runtime pe aati hai Example: ArithmeticException,
		 * NullPointerException, ArrayIndexOutOfBoundsException
		 * int a = 10 / 0;   // Runtime exception
		 */
		
		/*
		 * Throwable Java ka root class hai jisse saare errors aur exceptions derive
		 * hote hain. 
			Object
   				↓
			Throwable
   				↓
		-----------------------
		|                     |
		Exception           Error
		 */
		
		/*
		 * 1️⃣ Exception Program me handle ki ja sakne wali problems.
		 * Example:ArithmeticException, NullPointerException, IOException
		 */
		/*
		 * 2️⃣ Error Serious problems jo programmer control nahi kar sakta. Example:
		 * OutOfMemoryError, StackOverflowError Ye usually handle nahi kiye jate.
		 */
		/*Throwable me important methods
		getMessage()
		printStackTrace()
		toString()*/
		
//		| throw                          | throws                       |
//		| ------------------------------ | ---------------------------- |
//		| Manually exception throw karta | Method declare karta         |
//		| Object ke sath use hota        | Method signature me use hota |

	}
}
