package interview.questions;

public class RomanToInteger {

    public static int valueOfRoman(char ch){
        if(ch == 'I')
            return 1;
        if(ch == 'V')
            return 5;
        if(ch == 'X')
            return 10;
        if(ch == 'L')
            return 50;
        if(ch == 'C')
            return 100;
        if(ch == 'D')
            return 500;
        if(ch == 'M')
            return 1000;
        return -1;
    }
    public static int romanToInt(String s) {
        int result = 0 , prevValue = -1;
        int length = s.length();
        result = valueOfRoman(s.charAt(0));
        prevValue = result;
        int i = 1;
        while(i <  length){
            char ch = s.charAt(i);
            int value = valueOfRoman(ch);
            if(value > prevValue){
                result = result - prevValue * 2;
            }
            result = result + value;
            prevValue = value;
            i++;
        }
        return result;
    }
    public static void main(String [] args){
        int firstIndex = romanToInt("III");
        System.out.println("Index of first occurrence = "+firstIndex);
    }
}
