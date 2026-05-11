package resultPortal;

public class Student {

    private String name;
    private int rollno;
    private int marks1;
    private int marks2;
    private int marks3;


    public Student(String name, int rollno, int marks1, int marks2, int marks3) {
        this.name = name;
        this.rollno = rollno;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }
    
    public Student() {
    	
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public int getMarks1() {
        return marks1;
    }

    public void setMarks1(int marks1) {
        this.marks1 = marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public void setMarks2(int marks2) {
        this.marks2 = marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    public void setMarks3(int marks3) {
        this.marks3 = marks3;
    }
}