package interview.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static int findMajorityElementWithMap(int [] nums){
        int length = nums.length;
        if(length == 1)
            return nums[0];
        int maxFrequency = 0 , mostFrequentElement = 0;
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num:nums){
            Integer value = frequencyMap.get(num);
            frequencyMap.put(num,(value == null) ? 1 : value+1);
            if(value != null && value+1 > maxFrequency){
                maxFrequency = value+1;
                mostFrequentElement = num;
            }
        }
        return mostFrequentElement;
    }

    public static int findMajorityElementWithoutMap(int [] nums){
        int length = nums.length;
        if(length == 1)
            return nums[0];
        Arrays.sort(nums);
        return nums[(length - 1)/2];
    }

    public static int findMajorityElementWithMooresVotingAlgorithm(int [] nums){
        int candidate = 0 , count = 0;
        for(int num:nums){
            if(count == 0)
                candidate = num;
            if(num == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }

    public static void main(String [] args){
        int [] nums = {2,2,1,1,1,2,2};
        long startTime,endTime;
//        startTime = System.currentTimeMillis();
//        System.out.println("Majority Element = "+ findMajorityElementWithMap(nums));
//        endTime = System.currentTimeMillis();
//        System.out.println("Time taken = "+(endTime - startTime));

//        startTime = System.currentTimeMillis();
//        System.out.println("Majority Element With Array Method = "+findMajorityElementWithoutMap(nums));
//        endTime = System.currentTimeMillis();
//        System.out.println("Time taken = "+(endTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("Majority Element With Array Method = "+findMajorityElementWithMooresVotingAlgorithm(nums));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken = "+(endTime - startTime));

    }
}