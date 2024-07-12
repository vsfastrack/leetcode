package interview.questions.string.easy;

public class Reverse {
    //O(n) time complexity solution to reverse the array
    public void reverseString(char[] s) {
        int n = s.length;
        if(n < 2)
            return;
        int start = 0 , end = n-1;
        while ( start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String [] args){
        Reverse obj = new Reverse();
        char [] charArr = new char[]{'h','e','l','l','o'};
        obj.reverseString(charArr);
        for(char ch : charArr){
            System.out.print(ch +"  ");
        }
        System.out.println();
    }
}
