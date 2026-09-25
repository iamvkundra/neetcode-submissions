class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        solve(nums, target, 0, new ArrayList<>());
        return result;
    }

    private void solve(int[] nums, int target, int index, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        }
        if (target < 0 || index >= nums.length) {
            return;
        }
        
       for (int i=index; i< nums.length; i++) {
        if (index != i && nums[i-1] == nums[i]) continue;
            temp.add(nums[i]);
            solve(nums, target-nums[i], i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
