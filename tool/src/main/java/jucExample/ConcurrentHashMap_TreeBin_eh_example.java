package jucExample;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMap_TreeBin_eh_example {
    public static volatile AtomicInteger inr = new AtomicInteger(0);
    public static ConcurrentHashMap<Node,Integer> hashMap = new ConcurrentHashMap<>();
    static class Node{
        int flag;
        public Node(){
            flag=inr.incrementAndGet();
        }
        @Override
        public int hashCode() {
            return 1;
        }
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[16];
        for (int i = 0; i < 16; i++) {
            nodes[i]=new Node();
            hashMap.put(nodes[i],i);
        }

        int v = hashMap.get(nodes[0]);
        System.out.println(v);

    }
}
