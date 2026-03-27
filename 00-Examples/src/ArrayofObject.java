class Student {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    void display() {
        System.out.println(roll + " " + name);
    }
}


public class ArrayofObject {
	public class Test {
	    public static void main(String[] args) {

	        Student[] students = new Student[2];

	        students[0] = new Student(1, "Mayank");
	        students[1] = new Student(2, "Rahul");

	        for(Student s : students) {
	            s.display();
	        }
	    }
	}
}

/*
 * Step 1 Student[] students = new Student[2];
 * Memory View 
 * 📌 Stack:
 * students → reference
 * 
 *  📌 Heap:
 * [ null , null ]
 */
/*
 * Step 2 students[0] = new Student(1, "Mayank");
 * 📌 Heap:
 * students → [ ref1 , null ]
 * 
 * ref1 → Student Object roll = 1 name = "Mayank"
 */