package interview.questions;

import java.util.HashMap;
import java.util.Map;

public class Duplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int index = 0;
        Map<Integer , Integer> scannedMap = new HashMap<>();
        while(index < nums.length){
            Integer lastScannedIndex = scannedMap.get(nums[index]);
            if(lastScannedIndex != null)
                if(Math.abs(lastScannedIndex - index) <= k)
                    return true;
           scannedMap.put(nums[index],index);
            index++;
        }
        return false;
    }
    public static void main(String [] args){
        int [] nums = {1,0,1,1};
         System.out.println("Is duplicate = "+ containsNearbyDuplicate(nums,1));
    }
}
