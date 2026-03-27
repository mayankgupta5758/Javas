import java.io.*;

// Class must implement Serializable to allow serialization
class Student4 implements Serializable {
	private static final long serialVersionUID = 1L; // Recommended for version control
	String name;
	transient int age; // 'transient' means this field won't be serialized

	Student4(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class SerializationExample {
    void show(int a, double b) {
        System.out.println("int, double");
    }

    void show(double a, int b) {
        System.out.println("double, int");
    }
	public static void main(String[] args) {
		SerializationExample s = new SerializationExample();
//		s.show(10, 20); error compile time.
		Student4 s1 = new Student4("Alice", 22);
//		byte a = 1;
//		byte b = 2;
//		byte c = a+b; // compile time error.

		// Serialize object
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/test.txt"))) {
			oos.writeObject(s1);
			System.out.println("Object serialized successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Deserialize object
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/test.txt"))) {
			Student4 s2 = (Student4) ois.readObject();
			System.out.println("Name: " + s2.name + ", Age: " + s2.age); // Age will be 0 because it's transient
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

/*
 * Serializable is a marker interface in Java that indicates to the JVM that the
 * object of a class can be converted into a byte stream. Serialization is the
 * process of converting an object into a byte stream so it can be stored in a
 * file, sent over a network, or saved for later use.
 *  In Java, the Serializable
 * interface is a marker interface (an interface with no methods or fields)
 * present in the java.io package.
 * 
 * It is used to indicate that a class's objects can be serialized (converted
 * into a byte stream) and deserialized (reconstructed from a byte stream). Key
 * Points Package: java.io.Serializable Marker Interface: No methods to
 * implement. Acts as a flag to the Java Virtual Machine (JVM) and I/O classes
 * that the object is eligible for serialization. Purpose: Allows saving an
 * object’s state to a file, database, or sending it over a network.
 * Inheritance: All subclasses of a serializable class are automatically
 * serializable unless explicitly stated otherwise. Non-Serializable Fields: Use
 * the transient keyword to skip serialization of specific fields.F
 */
