class Solution {
    public int findKthNumber(int n, int k) {
        long current = 1;
        k--;

        while(k > 0) {
            long steps = calSteps(n, current, current+1);
            if (steps <= k) {
                current++;
                k -= steps;
            } else {
                current *= 10;
                k--;
            }
        }

        return (int) current;
    }

    private long calSteps(long n, long n1, long n2) {
        long steps = 0;
        while(n1 <= n) {
            steps += Math.min(n+1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}