package example;

class Student {
	private int id;
	private String fname;
	private String email;
	private double fees;
	static int count = 0;
	static int a = 2;
	static int b;
	static {
		b = a * 2;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.fname = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int countObject() {
		return count;
	}

	Student() {
		count++;
	}
	public void add() {
		System.out.println("Adding");
	}
//
//	Student(int id, String fname, String email, double fees) {
//		this.id = id;
//		this.fname = fname;
//		this.email = email;
//		this.fees = fees;
//	}

	public void greet() {
		System.out.println("Hello");
	}

}