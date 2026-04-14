package com.mayank.example.list;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class ListEx {
	/*
	 * The List interface in Java is a part of the java.util package and is a
	 * sub-interface of the Collection interface. It provides a way to store an
	 * ordered collection of elements (known as a sequence). Lists allow for precise
	 * control over where elements are inserted and can contain duplicate elements.
	 * 
	 * When you create an ArrayList, it has an initial capacity (default is 10). The
	 * capacity refers to the size of the internal array that can hold elements
	 * before needing to resize.
	 * 
	 * Adding Elements When we add an element to an ArrayList, the following steps
	 * occur
	 * 
	 * Check Capacity: Before adding the new element, ArrayList checks if there is
	 * enough space in the internal array (elementData). If the array is full, it
	 * needs to be resized.
	 * 
	 * Resize if Necessary: If the internal array is full, the ArrayList will create
	 * a new array with a larger capacity (usually 1.5 times the current capacity)
	 * and copy the elements from the old array to the new array.
	 * 
	 * Add the Element: The new element is then added to the internal array at the
	 * appropriate index, and the size is incremented.
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		System. out.println(list.getClass().getName());

		List<String> list1 = Arrays.asList("Monday", "Tuesday");
		System. out.println(list1.getClass().getName());
		list1.add("Wednesday"); // exception aa jayagi kyuki ye fix size hi hoti hai. ismee hum set kar sekta hai.
		
		String[] array = {"Apple", "Banana", "Cherry"};
		List<String> list2 = Arrays.asList(array);
		System.out.println(list2.getClass().getName());
		
		List<Integer> list3 = List.of(1, 2, 3, 4);
//		list3.set(1, 33); lakin ye un modifiable hoti hai.
		
		List<Integer> list4 = new ArrayList<>() ;
		list4.add(1);
		list4.add(2);
		list4.add(3);

		list4.remove(Integer.valueOf(1)); // ye object leta hai llike "Apple" nahi to index samjga use..
		System.out.println(list4);
	}
}






class Student implements Comparable<Student>{
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa  = gpa;
    }

    public String getName() { return name; }
    public double getGpa()  { return gpa; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(gpa, student.gpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.getGpa(), this.getGpa());
    }
}



class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Akshit", 3.9));

        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);


        students.sort((o1, o2) -> {
            if (o2.getGpa() - o1.getGpa() > 0) {
                return 1;
            } else if (o2.getGpa() - o1.getGpa() < 0) {
                return -1;
            } else {
                return o2.getName().compareTo(o1.getName());
            }
        });
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }
        Collections.sort(students, comparator);

/*        System.out.println(list.get(2));
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        for(int x: list){
            System.out.println(x);
        }
        System.out.println(list.contains(5));
        System.out.println(list.contains(50));

        list.remove(2);
        for(int x: list){
            System.out.println(x);
        }
        list.add(2, 50);

        for(int x: list){
            System.out.println(x);
        }

        list.add(1); // 0
        list.add(5); // 1
        list.add(80); // 2

        list.set(2, 50);

        System.out.println(list);


        ArrayList<Integer> list = new ArrayList<>(11);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: " + elementData.length);

        list.add(1);


        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: " + elementData.length);

        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);

        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: " + elementData.length);

        list.trimToSize();

        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: " + elementData.length);


 List<String> list = new ArrayList<>();
        System.out.println(list.getClass().getName());

        List<String> list1 = Arrays.asList("Monday", "Tuesday");
        System.out.println(list1.getClass().getName());
        list1.set(1, "Wednesday");
        System.out.println(list1.get(1));

        String[] array = {"Apple", "Banana", "Cherry"};
        List<String> list2 = Arrays.asList(array);
        System.out.println(list2.getClass().getName());

        List<String> list4 = new ArrayList<>(list2);
        list4.add("Mango");
        System.out.println(list4);


        List<Integer> list3 = List.of(1, 2, 3, 4);
        list3.set(1, 33);
        // removing first occurence

                List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(Integer.valueOf(1));
        System.out.println(list);

                Object[] array = list.toArray();
        Integer[] array1 = list.toArray(new Integer[0]);


        List<String> words = Arrays.asList("banana", "apple", "date");
        words.sort((a, b) -> b.length() - a.length());
        System.out.println(words);


        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        list.sort((a, b) -> b - a);
        System.out.println(list);

                List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Akshit", 3.9));

        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);

        students.sort(comparator);
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }

        */

    }

}
