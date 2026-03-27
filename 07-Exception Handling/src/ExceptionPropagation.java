import java.io.*;

public class ExceptionPropagation {
//	Jab ek method exception handle nahi karta, to wo upar wale method ko de deta hai.

	public static void withoutTryWith() {
		FileReader file = null;
		try {
			file = new FileReader("abc.txt");
			System.out.println("File opened");
		} catch (IOException e) {
			System.out.println("Error");
		} finally {
			try {
				if (file != null) {
					file.close(); // manually close
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//	👉 Iska use hota hai resource automatically close karne ke liye
	public static void withTryWith() {
		try (FileReader file = new FileReader("abc.txt")) {
			System.out.println("File opened");
		} catch (IOException e) {
			System.out.println("Error");
		}
//	Yaha file.close() automatically call ho jayega
//	-> Chahe exception aaye ya na aaye
	}

	public static void finallyKabNahiChalta() {
		/*
		 * 4️ finally Kab Nahi Chalega? Finally block hamesha chalta hai except:
		 * System.exit() call ho ,JVM crash ho Example:
		 */

		try {
			System.exit(0);
		} finally {
			System.out.println("Won't execute");
		}
	}
	
	static void m1() {
		int a = 10 / 0; // Exception here
	}

	static void m2() {
		m1(); // propagate to m2
	}

	public static void main(String[] args) {
		try {
			m2(); // finally handled here
		} catch (ArithmeticException e) {
			System.out.println("Handled in main");
		}
	}
	/*
	 * 👉 Flow: m1 → m2 → main → catch
	 */
}