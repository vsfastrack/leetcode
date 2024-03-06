package interview.questions;

public class MergeSortedArrays {

    public static void moveElementsToEnd(int [] nums,int m){
        int i = m , length = nums.length , j = length -1;
        while(i > 0){
            nums[j] = nums[i-1];
            i--;
            j--;
        }
    }

    public static void mergeSortedArrays(int [] nums1 , int m ,int [] nums2,int n){
        moveElementsToEnd(nums1,m);
        int i = n , j = 0 , k = 0;
        while(j < n && i< m + n){
            if(nums1[i] < nums2[j]){
                nums1[k++] = nums1[i++];
            }else if(nums2[j] < nums1[i]){
                nums1[k++] = nums2[j++];
            }else{
                nums1[k++] = nums2[j++];
                nums1[k++] = nums1[i++];
            }
        }
        while(j < n)
            nums1[k++] = nums2[j++];
        while(i < m+n)
            nums1[k++] = nums1[i++];
    }

    public static void main(String [] args){
        int [] nums1 = {1};
        int [] nums2 = {};
        mergeSortedArrays(nums1,1,nums2,0);
        for(int num:nums1){
            System.out.print(num + " ,");
        }
        System.out.println();
    }
}
