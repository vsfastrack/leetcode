public class ArrayUtils {

    public static int findFirstOccurrence(int [] nums , int low, int high, int key){
        if(low >= high)
            return low;
        int mid = (low + high)/2;
        if(nums[mid] < key)
           return findFirstOccurrence(nums , mid+1 , high ,key);
        if(nums[mid] > key || (nums[mid] == key && mid > low && nums[mid] == nums[mid-1]))
            return findFirstOccurrence(nums , mid, high-1 ,key);
        else
            return mid;
    }

    public static int findLastOccurrenceWithRecursion(int [] nums , int low, int high, int key){
        if(low >= high)
            return low;
        int mid = (low + high)/2;
        if(nums[mid] > key)
            return findLastOccurrenceWithRecursion(nums , low, mid-1 ,key);
        if(nums[mid] < key || (nums[mid] == key && mid < high && nums[mid] == nums[mid+1]))
            return findLastOccurrenceWithRecursion(nums , mid+1, high ,key);
        else
            return mid;
    }

    public static int findLastOccurrenceWithoutRecursion(int [] nums , int key){
        int low = 0;
        int high = nums.length - 1;
        int lastOccurrence = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == key) {
                lastOccurrence = mid;
                low = mid + 1;
            } else if (nums[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lastOccurrence;
    }

}
