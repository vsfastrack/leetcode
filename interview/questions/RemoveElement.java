package interview.questions;

public class RemoveElement {

    public static int removeElement(int [] nums , int val){
        int length = nums.length;
        int i = 0 , j = length -1;
        while(i <= j){
            if(nums[i] != val)
                i++;
            else{
                while(j > 0 && nums[j] == val){
                    j--;
                }
                if(j == i)
                    return 0;
                if(j < i)
                    return i;
                nums[i] = nums[j];
                nums[j] = val;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String [] args){
        int [] nums = {4,5};
        int uniqueElements =  removeElement(nums,5);
        System.out.println("Unique elements ="+uniqueElements);
        for(int i =0 ; i < uniqueElements ; i++){
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
