class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i=1; i<nums.length; i++) {
            left[i] = nums[i-1] * left[i-1];
        }

        int[] right = new int[left.length];
        right[right.length-1] = 1;
        for (int i=right.length-2; i>=0; i--) {
            right[i] = right[i+1]*nums[i+1];
        }

        int[] r = new int[nums.length];
        for (int i=0; i<left.length; i++) {
            r[i] = (right[i]*left[i]);
        }
        return r;
    }
}  
