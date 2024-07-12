package interview.questions.language;

import java.util.HashMap;
import java.util.Map;

public class ThreadCases {
    public static boolean isSubset(String str1, String str2){
        int length1 = str1.length();
        int length2 = str2.length();
        if(length1 < length2)
            return false;
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> srcMap = new HashMap<>();
        for(Character ch:str1.toCharArray()){
            if(targetMap.get(ch) == null){
                targetMap.put(ch,1);
            }else{
                int existingCount = targetMap.get(ch);
                targetMap.put(ch,existingCount+1);
            }
        }
        for(Character ch:str2.toCharArray()){
            if(srcMap.get(ch) == null){
                srcMap.put(ch,1);
            }else{
                int existingCount = targetMap.get(ch);
                srcMap.put(ch,existingCount+1);
            }
        }
        for(Character ch:str2.toCharArray()){
            if(targetMap.get(ch) != srcMap.get(ch)){
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
        System.out.println(isSubset("laxtzbdekm","ltbdm"));
        System.out.println(isSubset("laxtzbdekm","tbbax"));
    }
}
















