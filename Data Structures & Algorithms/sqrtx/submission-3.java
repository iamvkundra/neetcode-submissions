class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 2;
        int right = x/2;
        while(left <= right) {
            int mid = (left + right)/2;
            long middle = (long) mid * mid;
            if (middle == x) {
                return mid;
            }
            if (middle > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return right;
    }
}