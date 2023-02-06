package jucExample;

import lombok.var;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public class VarHandleExample<V> {

//    private static final VarHandle VALUE;
//    static {
//        try {
//            MethodHandles.Lookup l = MethodHandles.lookup();
//            VALUE = l.findVarHandle(AtomicReference.class, "value", Object.class);
//        } catch (ReflectiveOperationException e) {
//            throw new Error(e);
//        }
//    }
//
//    public final void lazySet(V newValue) {
//        VALUE.setRelease(this, newValue);
//    }
//
//    public final boolean compareAndSet(V expectedValue, V newValue) {
//        return VALUE.compareAndSet(this, expectedValue, newValue);
//    }

    public static void main(String[] args) {
        Data data = new Data();
        nonAtomicGetAndSetEvaluation(data);
    }
    private static class Data {
        public int counter = 1;
        private int privateField = 10;
        public String name = "Yoshio Terada";
        public byte[] data = new byte[]{1, 0, 0, 0, 1, 0, 0, 0};
        public char[] charArray = new char[]{'A','B','C','D','E','F'};
        public ByteBuffer dataBuffer = ByteBuffer.wrap(this.data);
    }

    public static void nonAtomicGetAndSetEvaluation(Data data){
        try {
            VarHandle varHandle = MethodHandles.lookup().findVarHandle(Data.class,"counter", int.class);
            Data data2 = new Data();
            //Read Access
            System.out.println(varHandle.get(data)); //アクセスモード： GET
            System.out.println(varHandle.getVolatile(data)); //アクセスモード： GET_VOLATILE
            System.out.println(varHandle.getOpaque(data)); //アクセスモード： GET_OPAQUE
            System.out.println(varHandle.getAcquire(data)); //アクセスモード：　GET_ACQUIRE

            //Write Access
            int newValue = 2;
            varHandle.set(data, newValue);
            System.out.println(varHandle.get(data));
            System.out.println(varHandle.get(data2));
            varHandle.setVolatile(data, newValue + 1);
            System.out.println(varHandle.get(data));
            varHandle.setOpaque(data, newValue + 2);
            System.out.println(varHandle.get(data));
            varHandle.setRelease(data, newValue + 3);
            System.out.println(varHandle.get(data));


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void arrayCheck(Data data) {
        VarHandle byteArrayViewVarHandle = MethodHandles.arrayElementVarHandle(char[].class);
        // char 配列 {'A','B','C','D','E','F'} より char を一つづつ取得
        for (int i = 0; i < data.charArray.length; i++) {
            var out = byteArrayViewVarHandle.getAcquire(data.charArray, i);
            System.out.println(out);
            // char が 'C' , 'D' ならば 'Z' に置き換え
            if (out.equals('C')|| out.equals('D')) {
                byteArrayViewVarHandle.setRelease(data.charArray, i, 'Z');
            }
        }
        // char 配列は {'A','B','Z','Z','E','F'} に置き換わる
    }


}
