package interview.questions;

public class IsValidPalindrome {

    public static boolean isAlphaNumeric(char character){
        return ((character >= '0' && character <= '9') ||
                (character >= 'a' && character <= 'z') ||
                (character >= 'A' && character <= 'Z'));
    }
    public static boolean isPalindrome(String s) {
        int i = 0 , j = s.length() - 1;
        while(i < j){
            char leadingChar = s.charAt(i);
            char trailingChar = s.charAt(j);
            boolean leadingCharCase = isAlphaNumeric(leadingChar);
            boolean trailingCharCase = isAlphaNumeric(trailingChar);
            if(leadingCharCase && trailingCharCase){
                if(Character.toLowerCase(leadingChar) == Character.toLowerCase(trailingChar)){
                    i++;
                    j--;
                }else
                    return false;
            }else if(!leadingCharCase){
                i++;
            }else{
                j--;
            }
        }
        return true;
    }
    public static void main(String [] args){
        System.out.println("Is Palindrome String = "+isPalindrome("A man, a plan, a canal: Panama"));
    }
}
