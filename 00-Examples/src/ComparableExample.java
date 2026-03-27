import java.util.*;

class Students implements Comparable<Students> {

    int roll;
    String name;

    Students(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public int compareTo(Students s) {
        return this.roll - s.roll;  
    }

    public String toString() {
        return roll + " " + name;
    }
}

public class ComparableExample {
    public static void main(String[] args) {

        List<Students> list = new ArrayList<>();
        list.add(new Students(3, "Aman"));
        list.add(new Students(1, "Riya"));
        list.add(new Students(2, "Karan"));

        Collections.sort(list);  

        System.out.println(list);
    }
}