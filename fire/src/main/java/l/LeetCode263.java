package l;

import util.PrintUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class LeetCode263 {
    public static void main(String[] args) {
        System.out.println("keep happy");
        Set<Integer> va = PrintUtil.toSet("1,2,3,4");
        PeekingIterator test = new PeekingIterator(va.iterator());
        System.out.println(test.next());
        System.out.println(test.peek());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.hasNext());
        System.out.println(test.next());
        System.out.println(test.hasNext());
    }

    static class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> result;
        private Integer peek;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.result=iterator;
            if(this.result.hasNext()){
                this.peek = this.result.next();
            }
        }

        // Returns the next element in the iteration_control without advancing the iterator.
        public Integer peek() {
            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer tmp = this.peek;
            if(this.result.hasNext()){
                this.peek=this.result.next();
            }else {
                this.peek=null;
            }
            return tmp;
        }

        @Override
        public boolean hasNext() {
           return this.result != null && this.peek != null;
        }
    }
}
