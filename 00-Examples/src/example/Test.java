package example;

class Test {

	public static void main(String[] args) {
//		int id = 10;
//		String name = "Mayank";
//		String email = "mayank@gmail.com";
//		double fees = 300000;
//		Student student = new Student();
//		student.greet();
//		student.setId(id);
//		student.setEmail(email);
//		student.setName(name);
//		student.setFees(fees);
//		Student student2 = new Student();
//		Student student3 = new Student();
//		Student student4 = new Student();
//		
//		System.out.println(student4.count);

		Student student = new Mayank();
//		student.add();
//student.add1(); // not allowed
//		Mayank.add();

//		System.out.println(student.email);
		
		Student a = new Mayank();   // Upcasting

		Mayank d = (Mayank) a;        // Downcasting

		student.add();
//		student.add1(); // not
		d.add();
		d.add1();
	}
}