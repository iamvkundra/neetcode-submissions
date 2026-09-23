class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = (start + end)/2;
            if (mid-1 >= 0 && mid + 1 < nums.length && nums[mid] < nums[mid-1] 
            && nums[mid] < nums[mid+1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return start >= 0 && start < nums.length ? nums[start] : -1;
    }
}
