package interview.questions.array.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    //Time complexity of O(n) since we are running single loop
    //Space complexity O(n) as we are using Set to store visited values
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return false;
        Set<Integer> occurrenceRecord = new HashSet<>();
        for(int num:nums){
            if(occurrenceRecord.contains(num))
                return true;
            occurrenceRecord.add(num);
        }
        return false;
    }
    public static void main(String [] args){
        int [] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        ContainsDuplicate obj = new ContainsDuplicate();
        boolean containsDupliacte = obj.containsDuplicate(nums);
        System.out.println("Contains dupliacte = "+containsDupliacte);
    }
}
