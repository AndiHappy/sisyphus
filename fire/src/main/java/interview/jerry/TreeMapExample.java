package interview.jerry;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(3,"c");
        map.put(9,"c");
        map.put(20,"c");
        System.out.println(map);

        NavigableSet<Integer> v1 =  map.navigableKeySet();
        System.out.println(v1);

        SortedSet<Integer> floor = v1.headSet(21);
        System.out.println(floor);
        SortedSet<Integer> floor1 = v1.headSet(2);
        System.out.println(floor1);
        SortedSet<Integer> floor3 = v1.tailSet(20);
        System.out.println(floor3);
    }
}
