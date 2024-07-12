package interview.questions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> uniqueTriplets = new ArrayList<>();
        for(int i = 0 ; i < length-1;i++){
            int target = -1 * nums[i];
            if( i == 0 || nums[i] > nums[i-1]){
                int start = i +1;
                int end = length -1;
                int [] triplet = new int[3];
                while(start < end){
                    if (start > i + 1
                            && nums[start] == nums[start - 1])
                    {
                        start++;
                        continue;
                    }
                    if (end < length - 1
                            && nums[end] == nums[end + 1])
                    {
                        end--;
                        continue;
                    }
                    if(nums[start] + nums[end] == target){
                        uniqueTriplets.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        start++;
                        end--;
                    }
                    else if (nums[start] + nums[end] < target)
                        start++;
                    else
                        end --;
                }
            }
        }
        return uniqueTriplets;
    }
    public static void main(String [] args){
        int [] nums = {-2,0,0,2,2};
        List<List<Integer>>result = threeSum(nums);
        for(int i =0 ; i< result.size() ; i++){
            List<Integer> triplet = result.get(i);
            System.out.print("[");
            for(int j = 0; j < triplet.size() ; j++){
                System.out.print(triplet.get(j) + " ");
            }
            System.out.println("]");
        }
    }
}
