package accumulate.hashmap;

import java.util.HashMap;

public class FindMaxNumOrCharacter {

    public int findMaxNumOrCharacter(String text){
        if(text == null || text.length() ==0) return 0;
        HashMap<Character,Integer> result = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if(result.get(text.charAt(i)) != null){
                result.put(text.charAt(i),result.get(text.charAt(i))+1);
            }else{
                result.put(text.charAt(i),1);
            }
        }

        int maxValue = result.values().stream().max(Integer::compare).get();
        return maxValue;
    }
}
