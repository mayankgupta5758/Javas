import java.util.*;

class NameComparator implements Comparator<Students> {

    public int compare(Students s1, Students s2) {
        return s1.name.compareTo(s2.name);
    }
}

public class ComparatorExample {
    public static void main(String[] args) {

        List<Students> list = new ArrayList<>();
        list.add(new Students(3, "Aman"));
        list.add(new Students(1, "Riya"));
        list.add(new Students(2, "Karan"));

        Collections.sort(list, new NameComparator());
        list.sort((s1, s2) -> s1.name.compareTo(s2.name));

        list.sort(Comparator.comparing(s -> s.name));

        System.out.println(list);
    }
}