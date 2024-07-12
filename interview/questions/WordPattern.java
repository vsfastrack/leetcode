package interview.questions;

import java.util.HashSet;
import java.util.Set;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        int len1 = pattern.length();
        String [] testParts = s.split(" ");
        if(len1 != testParts.length)
            return false;
        String [] patternMap = new String [26];
        Set<String> valueSet = new HashSet<>();
        int i = 0 , j = 0 ;
        while(i < len1 && j < testParts.length){
            int indexOfChar = (int) (pattern.charAt(i)) - 97;
            if(patternMap[indexOfChar] == null && !valueSet.contains(testParts[j])){
                patternMap[indexOfChar] = testParts[j];
                valueSet.add(testParts[j]);
            }else if (patternMap[indexOfChar] == null && valueSet.contains(testParts[j]))
                return false;
            else if(patternMap[indexOfChar] != null && !testParts[j].equals(patternMap[indexOfChar]))
                return false;
            i++;
            j++;
        }
        return true;
    }

    public static void main(String [] args){
        System.out.println("Does follow = "+wordPattern("abba","dog dog dog dog"));
    }

}
