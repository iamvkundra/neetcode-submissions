class Solution {
    Map<String, Integer> cache = new HashMap<>();
    private int solve(int[] nums, int target, int index) {
        if (index >= nums.length) {
            return target == 0 ? 1: 0;
        }
        String key = index + ":" + target;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int add = solve(nums, target+nums[index], index+1);
        int sub = solve(nums, target- nums[index], index+1);
        int sum = add + sub;
        cache.put(key, sum);
        return add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0);
    }
}
