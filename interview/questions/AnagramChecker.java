package interview.questions;


public class AnagramChecker {

    public static boolean isAnagram(String s, String t) {
        int [] scannedChars = new int[26];
        int len1 = s.length() , len2 = t.length() , i = 0 , j = 0;
        if(len1 != len2)
            return false;
        while ( i < len1){
            int indexOfChar  = (int) (s.charAt(i)-97);
            if(indexOfChar >= 0 && indexOfChar <= 26){
                int valueOccurrence = scannedChars[indexOfChar];
                scannedChars[indexOfChar] = valueOccurrence + 1;
            }
            i++;
        }
        while( j  <  len2) {
            int indexOfChar  = (int) (t.charAt(j)-97);
            if(indexOfChar >= 0 && indexOfChar <= 26){
                int valueOccurrence = scannedChars[indexOfChar];
                if(scannedChars[indexOfChar] == 0)
                    return false;
                scannedChars[indexOfChar] = valueOccurrence - 1;
            }
            j++;
        }
        return true;
    }
    public static void main(String [] args){
        System.out.println("Is Anagram = "+isAnagram("anagram","nagaram"));
    }
}
