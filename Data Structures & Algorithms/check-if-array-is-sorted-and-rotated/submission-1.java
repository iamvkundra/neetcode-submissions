class Solution {
    public boolean check(int[] nums) {
         int n = nums.length;
       if (n <= 1) {
        return true;
       }

       int index = 0;
       for (int i=1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                ++index;
                if (index > 1) {
                    return false;
                }
            }
       }

       if (nums[0] < nums[n-1]) {
         ++index;
       }
       return index <= 1;
    }
}