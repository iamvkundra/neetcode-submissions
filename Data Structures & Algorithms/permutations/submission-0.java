class Solution {
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        solve(nums, 0);
        return result;
    }

    private void solve(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }
        for (int i=index; i<nums.length; i++) {
            swap(nums, index, i);
            solve(nums, index+1);
            swap(nums, index, i);
        }
    }
}
