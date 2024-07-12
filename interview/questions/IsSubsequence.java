package interview.questions;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int len1 = t.length() , len2 = s.length() , i = 0 , j = 0;
        while(i < len1 && j < len2){
            if(t.charAt(i) == s.charAt(j)){
                j++;
            }
            i++;
        }
        return j == len2;
    }

    public static void main(String [] args){
        System.out.println("Is SubSequence= "+isSubsequence("axc","axxxxc"));
    }
}
