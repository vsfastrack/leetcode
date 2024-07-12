package interview.questions.array.medium;

public class PeakElement {

    public int findPeak(int [] nums, int low , int high){
        if(low > high)
            return -1;
        int mid = (low + high)/2;
        if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1])
            return mid;
        else if(nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1])
            return findPeak(nums,low,mid-1);
        else
            return findPeak(nums,mid+1,high);
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        if(nums[n-1] > nums[n-2])
            return n-1;
        return findPeak(nums,1,n-2);
    }
    public static void main(String [] args){
        PeakElement obj = new PeakElement();
//        int [] nums = new int[]{1,2,1,3,5,6,4};
        int [] nums = new int[]{1,2};
        int PeakIndex = obj.findPeakElement(nums);
        System.out.println("Index of peak element = "+PeakIndex);
    }
}
