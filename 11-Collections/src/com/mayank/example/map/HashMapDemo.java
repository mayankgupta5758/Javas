package com.mayank.example.map;

import java.util.*;

/*
 * Map (Separate Interface)
I
SortedMap

ConcurrentMap

HashMap

Hashtable

(legacy)

ConcurrentHashMap
NavigableMap ConcurrentSkipListMap

TreeMap

LinkedHashMap
WeakHashMap
IdentityHashMap
 * Map does not extend the Collection interface
 * 
 * Key Characteristics of the Map Interface
 * 
 * Key-Value Pairs: Each entry in a Map consists of a key and a value. Unique
 * Keys: No two entries can have the same key. One Value per Key: Each key maps
 * to a single value. Order: Some implementations maintain insertion order
 * (LinkedHashMap), natural order (TreeMap), or no order (HashMap).
 * 
 * Key Characteristics
 * 
 * Unordered: Does not maintain any order of its elements. Allows null Keys and
 * Values: Can have one null key and multiple null values. Not Synchronized: Not
 * thread-safe; requires external synchronization if used in a multi-threaded
 * context. Performance: Offers constant-time performance (O(1)) for basic
 * operations like get and put, assuming the hash function disperses elements
 * properly.
 * 
 * A hash function is an algorithm that takes an
input (or "key") and returns a fixed-size string
of bytes, typically a numerical value. The
output is known as a hash code, hash value, or
simply hash. The primary purpose of a hash
function is to map data of arbitrary size to
data of fixed size

· Deterministic: The same input will always produce the same output.
· Fixed Output Size: Regardless of the input size, the hash code has a
consistent size (e.g., 32-bit, 64-bit).
. Efficient Computation: The hash function should compute the hash
quickly.

How Data is Stored in HashMap

Step 1: Hashing the Key

First, the key is passed through a hash function to generate
a unique hash code (an integer number). This hash code
helps determine where the key-value pair will be stored in
the array (called a "bucket array").

Step 2: Calculating the Index

The hash code is then used to calculate an index in the array (bucket
location) using
int index = hashCode % arraySize;

The index decides which bucket will hold this key-value pair.

For example, if the array size is 16, the key's hash code will be divided by
16, and the remainder will be the index.

Step 3: Storing in the Bucket

The key-value pair is stored in the bucket at the calculated index. Each
bucket can hold multiple key-value pairs

(this is called a collision handling mechanism, discussed later).

How HashMap Retrieves Data

When we call get(key), the HashMap follows these steps:

Hashing the Key: Similar to insertion, the key is hashed using the same hash
function to calculate its hash code.

Finding the Index: The hash code is used to find the index of the bucket where
the key-value pair is stored.

Searching in the Bucket: Once the correct bucket is found, it checks for the
key in that bucket. If it finds the key, it returns the associated value.
jab linked list ka size 8  se bada ho jata hai java 8 ke baad se vo RB tree me convert ho jata jis se tc lolg(n) ho jati hai.

HashMap Resizing (Rehashing)

HashMap has an internal array size, which by default is 16.
When the number of elements (key-value pairs) grows and
exceeds a certain load factor (default is 0.75), HashMap
automatically resizes the array to hold more data. This process is
called rehashing.

The default size of the array is 16, so when more than 12
elements (16 * 0.75) are inserted, the HashMap will resize.
During rehashing

The array size is doubled.

1. All existing entries are rehashed (i.e., their positions are recalculated)
and placed into the new array.
2. This ensures the HashMap continues to perform efficiently even as
more data is added.

Time Complexity

HashMap provides constant time O(1) performance for basic
operations like put() and get() (assuming no collisions).
However, if there are many collisions, and many entries are
stored in the same bucket, the performance can degrade to O(n),
where n is the number of elements in that bucket.

But after Java 8, if there are too many elements in a bucket,
HashMap switches to a balanced tree instead of a linked list to
ensure better performance O(log n).
 */

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>(17, 0.5f);
		map.put(31, "Shubham");
		map.put(11, "Akshit");
		map.put(2, "Neha");
		map.put(2, "Mehul");
		System.out.println(map);

		String student = map.get(31);
		System.out.println(student);
		String s = map.get(69);
		System.out.println(s);

		System.out.println(map.containsKey(2));
		System.out.println(map.containsValue("Shubham"));

		for (int i : map.keySet()) {
			System.out.println(map.get(i));
		}

		Set<Map.Entry<Integer, String>> entries = map.entrySet();

		for (Map.Entry<Integer, String> entry : entries) {
			entry.setValue(entry.getValue().toUpperCase());
		}
		System.out.println(map);

//        map.remove(31);
		boolean res = map.remove(31, "Nitin");
		System.out.println("REMOVED ? :" + res);
		System.out.println(map);

		List<Integer> list = Arrays.asList(2, 4, 32, 43, 4, 432);
		list.contains(32);
	}
}