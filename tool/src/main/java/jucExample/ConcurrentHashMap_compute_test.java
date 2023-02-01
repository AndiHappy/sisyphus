package jucExample;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap_compute_test {
    public static void main(String[] args) {
//        testHashMap();
        ConcurrentHashMap<String, Integer> mapcon = new ConcurrentHashMap<>();
        mapcon.put("A", 26);
        mapcon.put("B", 98);
        mapcon.put("C", 55);
        System.out.println("ConcurrentHashMap values:\n "+ mapcon.toString());
        mapcon.computeIfPresent("C", (key , val)  -> val + 100);
        System.out.println("new ConcurrentHashMap after  computeIfPresent:\n " + mapcon);
    }

    private static void testHashMap() {
        HashMap<String, Integer> mapcon = new HashMap<>();
        mapcon.put("k1", 100);
        mapcon.put("k2", 200);
        mapcon.put("k3", 300);
        mapcon.put("k4", 400);

        System.out.println("HashMap values:\n " + mapcon.toString());
        mapcon.computeIfPresent("k4", (key, val) -> val + 100);
        mapcon.computeIfPresent("k5", (key, val) -> val + 100);
        System.out.println("New HashMap after computeIfPresent:\n " + mapcon);
    }
}
