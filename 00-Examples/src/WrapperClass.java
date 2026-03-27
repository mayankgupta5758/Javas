
public class WrapperClass {

	public static void main(String[] args) {
//		Autoboxing (Primitive → Object)
		int num = 20;
        Integer obj = num;  
        System.out.println(obj);
//        Integer obj = Integer.valueOf(a);
        
//        Unboxing (Object → Primitive)
        Integer obj1 = 100;
        int num1 = obj1;   
        System.out.println(num1);
//        int a = obj.intValue();//internally
        
        Integer a0 = -128;
        Integer b0 = -128;
        System.out.println(a0 == b0); // true.
        
//        Integer a = 200;
//        Integer b = 200;
//        System.out.println(a == b); // false
//        Java -128 se 127 tak ke numbers ko cache (store) karke rakhta hai.
         /* Stack                Heap (Integer Cache)

        a  ─────┐
                ├──► Integer object (100)
        b  ─────┘
        a == b  → true
        
        Stack                Heap

a  ───► Integer object (200)

b  ───► Integer object (200)
a == b → false

Java internally kya karta hai
Jab tum likhte ho:
Integer a = 100;
Java internally karta hai:
Integer a = Integer.valueOf(100);
Method used:
Integer.valueOf()
Ye method cache check karta hai.
Agar value -128 to 127 me hai to existing object return karta hai.

Ye optimization kyu hai?
Reason:
Small numbers bahut frequently use hote hain.
Example:
0
1
10
100
Agar har baar new object banega to:
memory waste hogi
performance slow hogi
Isliye Java caching use karta hai.
        */
	}

}
