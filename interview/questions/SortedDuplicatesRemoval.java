package interview.questions;

import java.util.Arrays;

public class SortedDuplicatesRemoval {
    public static int removeDuplicates(int[] nums) {
        int i = 0 , j = 1 , k = 0 , length = nums.length , nonUniqueCount = 0;
        while( j < length){
            if(nums[j] == nums[i])
                j++;
            else{
                nums[i] = nums[j];
            }
        }
        return i;
    }
    public static void main(String [] args){
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        int uniqueElements = removeDuplicates(nums);
        System.out.println("Unique elements = "+uniqueElements);
        for(int num:nums){
            System.out.print(num + "  ,");
        }
        System.out.println();
    }
}
