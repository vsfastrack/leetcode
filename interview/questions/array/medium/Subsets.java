package interview.questions.array.medium;

import java.util.*;

public class Subsets {
    List<List<Integer>> subSets = new ArrayList<>();

    public void selectSets(int [] nums,int index){
        if(index == nums.length - 1){
            subSets.add(Collections.singletonList(nums[index]));
            return;
        }
        int currentItem = nums[index];
        selectSets(nums,index+1);
        List<List<Integer>> combinationList = new ArrayList<>();
        for (List<Integer> subSet : subSets) {
            Integer [] combinationArr = new Integer[subSet.size() + 1];
            for(int k = 0 ; k < subSet.size() ; k++)
                combinationArr[k] = subSet.get(k);
            combinationArr[subSet.size()] = currentItem;
            combinationList.add(Arrays.asList(combinationArr));
        }
        subSets.addAll(combinationList);
        subSets.add(Collections.singletonList(currentItem));
    }

    public List<List<Integer>> subsets(int[] nums) {
        selectSets(nums,0);
        subSets.add(Collections.emptyList());
        return subSets;
    }
}
