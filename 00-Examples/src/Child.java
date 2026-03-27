

public class Child extends Parent {
	public void Hello() { 
		System.out.println("Child Hello");
	}
	private Child() {
//		super();
//		this(); // ye error dega Recursive constructor invocation Child()
//		this(1);
//		this.Hello();
	}
	Child(int h) {
		this.Hello();
		super.Hello();
		// agar this uper hai to child hello phela ayega.
		// agar super uoer hai to parent hello ayega.
		// staticlaga du to bas warning ayagi.
	}
	

	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child);
//		Parent p = new Parent(); // errror
	}

}
