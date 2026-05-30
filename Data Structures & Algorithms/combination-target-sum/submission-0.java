class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<Integer> currentList = new ArrayList<>();
        helper(nums, 0, currentList, target);

        return res;
    }

    private void helper(int[] nums, int index, List<Integer> curr, int target) {
        if(index == nums.length || target < 0) {
            return;
        }

        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        //helper(nums, index+1, curr, target - nums[index]);
        helper(nums, index, curr, target - nums[index]);
        curr.remove(curr.size() - 1);
        helper(nums, index+1, curr, target);
    }
}
