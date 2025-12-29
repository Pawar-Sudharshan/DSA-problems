import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int num : nums) {
        
            if (!currentPermutation.contains(num)) {
                currentPermutation.add(num);
                backtrack(nums, currentPermutation, result);
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
}