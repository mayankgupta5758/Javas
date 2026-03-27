
public class CallStack {

	public static void main(String[] args) {
		System.out.println("Main Start");
		methodA();
		System.out.println("Main End");
	}

	static void methodA() {
		System.out.println("Method A Start");
		methodB();
		System.out.println("Method A End");
	}

	static void methodB() {
		System.out.println("Method B");
	}
}
