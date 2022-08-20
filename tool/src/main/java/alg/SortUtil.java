package alg;

import java.util.ArrayList;
import java.util.List;

public class SortUtil {


    public static void main(String[] args) {
        System.out.println("test");
    }

    /**
     * 全排列
     * */
    public static <T> List<List<T>>  allPermutation(T[] input){
        List<T> tmp = new ArrayList<>();
        List<List<T>> result = new ArrayList<>();
        allPermutation(input,result,tmp,0);
        return result;
    }

    private static <T> void  allPermutation(T[] input, List<List<T>> result, List<T> tmp, int i) {

        if(tmp.size() == input.length){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int j = i; j < input.length; j++) {
            if(!tmp.contains(input[j])){
                tmp.add(input[j]);
                allPermutation(input,result,tmp,0);
                tmp.remove(input[j]);
            }
        }
    }
}
