package interview.questions.array.easy;

import java.util.Arrays;

public class ChocolateDistribution {

    public long findMinDiff (int [] chocolates, int m)
    {
        int n = chocolates.length;
        Arrays.sort(chocolates);
        int start = 0 , end = m-1 ;
        long min_diff = Long.MAX_VALUE;
        while(end < n){
            min_diff = Math.min(min_diff,(chocolates[end] - chocolates[start]));
            end++;
            start++;
        }
        return min_diff;
    }
    public static void main(String [] args){
        int [] nums = new int[]{3, 4, 1, 9, 56, 7, 9, 12};
        ChocolateDistribution obj = new ChocolateDistribution();
        long min_diff = obj.findMinDiff(nums,5);
        System.out.println("Minimum difference between chocolates = "+min_diff);
    }
}
