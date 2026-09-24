class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i=1; i<s.length(); i++) {
            sum += Math.abs((s.charAt(i) - '0') - (s.charAt(i-1) - '0'));
        }
        return sum;
    }
}