import java.util.ArrayList;
import java.util.Comparator;

class Employee {

    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

public class ComparatorComparing {
	    public static void main(String[] args) {

	        ArrayList<Employee> list = new ArrayList<>();

	        list.add(new Employee("Rahul",28,50000));
	        list.add(new Employee("Aman",25,40000));
	        list.add(new Employee("Vikas",30,60000));
	        list.add(new Employee("Neha",25,45000));
	        
	        list.sort(Comparator.comparing(e -> e.age));
//			list.sort(Comparator.comparing((Employee e) -> e.age).thenComparing(e -> e.salary));
	        
	        for(Employee e : list){
	            System.out.println(e.name+" "+e.age+" "+e.salary);
	        }
	    }
	}
