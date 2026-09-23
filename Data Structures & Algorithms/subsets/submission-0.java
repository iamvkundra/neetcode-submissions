class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0, new ArrayList<>());
        return result;
    }

    private void solve(int[] nums, int index, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            solve(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
