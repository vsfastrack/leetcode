package interview.questions;

public class FirstOccurrenceOfSubstring {
    public static int findFirstOccurrenceOfSubstring(String  haystack, String needle){
        if("".equals(haystack) || "".equals(needle))
            return -1;
        int l1 = haystack.length();
        int l2 = needle.length();
        if(l2 > l1)
            return -1;
        int i = 0 , j , k , l = -1;
        while(i <  l1){
            if(haystack.charAt(i) != needle.charAt(0))
                i++;
            else{
                j = 1 ;
                k = i+1;
                while(k < l1 && j < l2 && haystack.charAt(k) == needle.charAt(j)){
                    if(haystack.charAt(k) == needle.charAt(0))
                        l = k;
                    j++;
                    k++;
                }
                if(j == l2)
                    return i;
                i = (l != -1 ) ? l : k;
                l = -1;
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int firstIndex = findFirstOccurrenceOfSubstring("aabaaabaaac","aabaaaac");
        System.out.println("Index of first occurrence = "+firstIndex);
    }

}
