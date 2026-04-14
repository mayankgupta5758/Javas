package com.mayank.example.list;

import java.util.Vector;

public class VectorEx {
	/*
	 * A Vector in Java is a part of the java.util package and is one of the legacy
	 * classes in Java that implements the List interface.
	 * 
	 * It was introduced in JDK 1.0 before collection framework and is synchronized,
	 * making it thread-safe.
	 * 
	 * Now it is a part of collection framework.
	 * 
	 * However, due to its synchronization overhead, it's generally recommended to
	 * use other modern alternatives like ArrayList in single-threaded scenarios.
	 * Despite this, Vector is still useful in certain situations, particularly in
	 * multi- threaded environments wher e thread safety is a concern.
	 * 
	 * Key Features of Vector Dynamic Array: Like ArrayList, Vector is a dynamic
	 * array that grows automatically when more elements are added than its current
	 * capacity.
	 * 
	 * Synchronized: All the methods in Vector are synchronized, which makes it
	 * thread-safe. This means multiple threads can work on a Vector without the
	 * risk of corrupting the data. However, this can introduce performance overhead
	 * in single-threaded environments.
	 * 
	 * Legacy Class: Vector was part of Java's original release and is considered a
	 * legacy class. It's generally recommended to use ArrayList in single-threaded
	 * environments due to performance considerations.
	 * 
	 * Resizing Mechanism: When the current capacity of the vector is exceeded, it
	 * doubles its size by default (or increases by a specific capacity increment if
	 * provided).
	 * 
	 * Random Access: Similar to arrays and ArrayList, Vector allows random access
	 * to elements, making it efficient for accessing elements using an index.
	 * 
	 * Constructors of Vector
	 * 
	 * Vector(): Creates a vector with an initial capacity of 10.
	 * 
	 * Vector(int initialCapacity): Creates a vector with a specified initial
	 * capacity.
	 * 
	 * Vector(int initialCapacity, int capacityIncrement): Creates a vector with an
	 * initial capacity and capacity increment (how much the vector should grow when
	 * its capacity is exceeded).
	 * 
	 * Vector(Collection <? extends E> c): Creates a vector containing the elements
	 * of the specified collection.
	 * 
	 * Methods in Vector
	 * 
	 * . add(E e): Adds an element at the end. . add(int index, E element): Inserts
	 * an element at the specified index. . get(int index): Retrieves the element at
	 * the specified index. · set(int index, E element): Replaces the element at the
	 * specified index. · remove(Object o): Removes the first occurrence of the
	 * specified element. . remove(int index): Removes the element at the specified
	 * index. · size(): Returns the number of elements in the vector. · isEmpty():
	 * Checks if the vector is empty. . contains(Object o): Checks if the vector
	 * contains the specified element. · clear(): Removes all elements from the
	 * vector.
	 * 
	 * Internal Implementation of Vector Internally, Vector uses an array to store
	 * its elements. The size of this array grows as needed when more elements are
	 * added. The default behavior is to double the size of the array when it runs
	 * out of space. This resizing operation is a costly one, as it requires copying
	 * the old elements to the new, larger array.
	 * 
	 * Synchronization and Performance Since Vector methods are synchronized, it
	 * ensures that only one thread can access the vector at a time. This makes it
	 * thread-safe but can introduce performance overhead in single-threaded
	 * environments because synchronization adds locking and unlocking costs. In
	 * modern Java applications, ArrayList is generally preferred over Vector when
	 * synchronization isn't required. For thread-safe collections, the
	 * CopyOnWriteArrayList or ConcurrentHashMap from the java.util.concurrent
	 * package is often recommended instead.
	 * 
	 * 1. Vector is a legacy synchronized collection class that implements the List
	 * interface. 2. It behaves like a dynamic array and grows as needed. 3. It
	 * provides thread safety but with a performance cost in single-threaded
	 * environments. 4. In modern applications, ArrayList or concurrent alternatives
	 * like CopyOnWriteArrayList are typically preferred over Vector unless thread
	 * safety is a priority.
	 */
}

class VectorDemo {
	public static void main(String[] args) {
//        Vector<Integer> list = new Vector<>(5, 3);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        System.out.println(list.capacity());
//        list.add(1);
//        System.out.println(list.capacity());
//        list.add(1);
//        list.add(1);
//        System.out.println(list.capacity());
//        list.add(1);
//        System.out.println(list.capacity());
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        Vector<Integer> vector1 = new Vector<>(linkedList);
//        System.out.println(vector1);
//        for(int i = 0; i < vector1.size(); i++){
//            System.out.println(vector1.get(i));
//        }
//        vector1.clear();
//        System.out.println(vector1);

		Vector<Integer> list = new Vector<>();
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Size of list: " + list.size()); // Output: 2000

	}
}
