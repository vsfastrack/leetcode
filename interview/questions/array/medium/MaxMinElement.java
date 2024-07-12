package interview.questions.array.medium;

public class MaxMinElement {

    public int[] findMinMaxUsingRecursion(int [] nums, int low, int high){
        if(low + 1 == high){
            int [] result = new int[2];
            if(nums[low] < nums[high]){
                result[0] = nums[low];
                result[1] = nums[high];
            }else{
                result[0] = nums[high];
                result[1] = nums[low];
            }
            return result;
        }
        int mid = (low + high)/2;
        int [] min_max_from_left = findMinMaxUsingRecursion(nums,low,mid-1);
        int [] min_max_from_right = findMinMaxUsingRecursion(nums,mid+1,high);
        return new int[]{Math.min(min_max_from_left[0] , min_max_from_right[0]),
                        Math.max(min_max_from_left[1],min_max_from_right[1])};
    }
    public int[] findMinMax(int [] nums){
        int n = nums.length;
        if( n  == 1)
            return new int[]{nums[0],nums[0]};
        return findMinMaxUsingRecursion(nums,0,n-1);
    }

    public static void main(String [] args){
        MaxMinElement obj = new MaxMinElement();
        int [] nums = new int[]{3, 5, 4, 1, 9};
        int [] min_max = obj.findMinMax(nums);
        for(int element:min_max){
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
