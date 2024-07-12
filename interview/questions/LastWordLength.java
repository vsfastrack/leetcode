package interview.questions;

public class LastWordLength {

    public static int lengthOfLastWord(String s) {
        int length = s.length() , count = 0 , j = length -1 ;
        while(j >= 0 && s.charAt(j) == ' ')
            j--;
        while(j >= 0 && s.charAt(j) != ' '){
            count++;
            j--;
        }
        return count;
    }

    public static void main(String [] args){
        int lastWordLength = lengthOfLastWord(" ");
        System.out.println("Length of last word = "+lastWordLength);
    }
}
