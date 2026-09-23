class Solution {

    private boolean isValidPalindrome(String s, int i, int j) {
        int left = i; int right = j;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        for (int i=0, j = s.length()-1; i < s.length() && j >= 0; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValidPalindrome(s, i+1, j) || isValidPalindrome(s, i, j-1);
            }
        }
        return true;
    }
}