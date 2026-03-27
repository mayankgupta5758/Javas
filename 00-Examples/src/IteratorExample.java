import java.util.*;

/*🔹 1️⃣ hasNext()
Check karta hai ki next element available hai ya nahi.

🔹 2️⃣ next()
Next element return karta hai.

🔹 3️⃣ remove()
Current element ko safely collection se remove karta hai.

| Feature         | Iterator     | for-each     |
| --------------- | ------------ | ------------ |
| Remove allowed? | ✅ Yes        | ❌ No         |
| Direction       | Forward only | Forward only |
| Manual control  | Yes          | No           |

ListIterator → Forward + Backward traversal
*/


public class IteratorExample {
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}