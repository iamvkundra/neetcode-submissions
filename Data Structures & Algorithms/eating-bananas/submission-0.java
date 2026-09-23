class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MAX_VALUE;
        int ans = -1;
        while(start <= end) {
            int mid = (start + (end-start)/2);
            if (canEat(piles, h, mid)) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }

    private boolean canEat(int[] piles, int hour, int banana) {
        int temp = 0;
        for (int i=0; i<piles.length; i++) {
            temp += piles[i]/banana;
            if (piles[i]%banana != 0) {
                temp++;
            }
        }
        return temp <= hour;
    }
}
