package interview.questions;

import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> indexMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            Integer value = indexMap.get(nums[i]);
            if(value == null)
                indexMap.put(target - nums[i],i);
            else
                return new int[]{value , i};

        }
        return new int[]{-1,-1};
    }
    public static void main(String [] args){
        int [] nums = {3,2,4};
        int [] indices = twoSum(nums , 6);
        for(int index:indices)
            System.out.print(index + "  ");
    }
}
