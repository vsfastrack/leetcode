package interview.questions.array.medium;

public class SearchInRotatedAndSorted {

    //Used to find pivot if unique elements in nums O(logn)
    public int findPivot(int [] nums,int low, int high , int n){
        int mid = (low + high)/2;
        if(mid > 0 && nums[mid] < nums[mid-1])
            return mid- 1;
        if(mid < n-1 && nums[mid] >  nums[mid+1])
            return mid;
        if(nums[mid] >= nums[0] && nums[mid] >= nums[n-1])
            return findPivot(nums,mid+1,high,n);
        else
            return findPivot(nums,low,mid-1,n);
    }

    //Used to find pivot if duplicate elements exist in nums O(n)
    public int findPivot(int [] nums , int n){
        for(int i = 1 ; i < n ; i++){
            if(nums[i-1] > nums[i]){
                return i-1;
            }
        }
        return -1;
    }

    public int binarySearch(int [] nums, int target,int low, int high){
        if(low > high)
            return -1;
        int mid = (low + high)/2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] > target)
            return binarySearch(nums,target,low, mid-1);
        else
            return binarySearch(nums,target,mid+1, high);
    }

    public boolean searchOnDuplicates(int [] nums,int target){
        int start = 0 , end = nums.length - 1;
        while ( start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target)
                return true;
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target <= nums[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }else{
                if(nums[mid] <= target && target <= nums[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int n= nums.length;
        if( n== 1)
           return  nums[0] == target;
        int pivot = findPivot(nums,0,n-1,n);
        int index = binarySearch(nums,target,pivot+1,n-1);
        if(index != -1)
            return true;
        index  = binarySearch(nums,target,0,pivot);
        return index != -1;
    }

    public static void main(String [] args){
        SearchInRotatedAndSorted obj = new SearchInRotatedAndSorted();
        int [] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        boolean isPresent = obj.searchOnDuplicates(nums,2);
        System.out.println("isPresent = "+isPresent);
    }
}
