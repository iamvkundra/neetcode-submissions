class Solution {
    Map<String, Boolean> cache = new HashMap<>();
    private boolean solve(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index >= nums.length || target < 0) {
            return false;
        }
        String key = target + ":" + index;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        boolean exclude = solve(nums, index+1, target);
        boolean include = solve(nums, index+1, target-nums[index]);

        boolean result = include || exclude;
        cache.put(key, result);
        return result;
    }
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total%2 != 0) {
            return false;
        }
        int target = total/2;
        
        return solve(nums, 0, target);
    }
}
