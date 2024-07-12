package interview.questions;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> characterMap = new HashMap<>();
        for(char ch:magazine.toCharArray()){
            characterMap.merge(ch, 1, Integer::sum);
        }
        for(char ch:ransomNote.toCharArray()){
            Integer count = characterMap.get(ch);
            if(count == null || count == 0)
                return false;
            characterMap.put(ch, count - 1);
        }
        return true;
    }
    public static void main(String [] args){
        System.out.println("Can construct= "+canConstruct("aa","ab"));
    }
}
