
public class StringExample {
	public static void s (int a) {
		System.out.println(a);
	}
	public static void show(Integer a) {
        System.out.println("Integer");
    }
	public static void show(int a) {
        System.out.println("int");
    }

    
	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = s1.intern(); // Adds "hello" to SCP if not present
		String s3 = "hello"; // Refers to SCP directly

		System.out.println(s1 == s2); // false: s1 is in heap, s2 is in SCP
		System.out.println(s2 == s3); // true: both refer to SCP
		String s4 = s1;
		System.out.println(s1 == s4); // true
		s1.intern();
		System.out.println(s1==s3); // false
		s('A'); // 65
		show(10);
	}
}
