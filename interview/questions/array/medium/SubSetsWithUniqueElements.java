package interview.questions.array.medium;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class SubSetsWithUniqueElements {

    List<List<Integer>> subSets = new ArrayList<>();
    Set<Integer> visitedNumbers = new HashSet<>();

    public void selectSets(int [] nums,int index){
        if(index == nums.length - 1){
            subSets.add(Collections.singletonList(nums[index]));
            visitedNumbers.add(nums[index]);
            return;
        }
        int currentItem = nums[index];
        selectSets(nums,index+1);
        List<List<Integer>> combinationList = new ArrayList<>();
        for (List<Integer> subSet : subSets) {
            List<Integer> combination = new ArrayList<>(subSet);
            combination.add(currentItem);
            combinationList.add(combination);
        }
        subSets.addAll(combinationList);
        if(!visitedNumbers.contains(currentItem)){
            subSets.add(Collections.singletonList(currentItem));
            visitedNumbers.add(currentItem);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        selectSets(nums,0);
        subSets.add(Collections.emptyList());
        return subSets;
    }

    public static void main(String [] args){
        SubSetsWithUniqueElements obj = new SubSetsWithUniqueElements();
        int [] nums = new int[]{0};
        List<List<Integer>> uniqueSubSets = obj.subsets(nums);
        System.out.println("Subsets size = "+uniqueSubSets.size());
        for (List<Integer> uniqueSubSet : uniqueSubSets) {
            for (Integer integer : uniqueSubSet) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
