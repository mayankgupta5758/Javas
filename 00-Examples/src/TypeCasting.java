
public class TypeCasting {

	public static void main(String[] args) {
		/*
		 * 1️. Widening=Implicit Casting (Widening Casting) 👉 Jab chhote data type ko bade data
		 * type me convert karte hain. 👉 Ye automatically ho jata hai. 👉 Data loss
		 * nahi hota.
		 * 
		 * Order: byte → short → int → long → float → double
		 * 
		 */
		int num = 10;
		double d = num;
		System.out.println(d);

		/*
		 * 2️⃣ Narrowing=Explicit Casting (Narrowing Casting)
		 * 
		 * 👉 Jab bade data type ko chhote data type me convert karte hain. 👉 Manually
		 * karna padta hai. 👉 Data loss ho sakta hai.
		 */

		double dr = 10.75;
		int nump = (int) dr;

		System.out.println(nump);
		
		
//		3️⃣ Char and Int Casting Example
		char ch = 'A';
        int ascii = ch;
        System.out.println(ascii);
        
	}
}
