class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve(n, 1, 0, "(");
        return result;
    }

    private void solve(int n, int open, int close, String str) {
        if (str.length() == n * 2) {
            result.add(str);
            return;
        }

        if (open < n) {
            solve(n, open+1, close, str + "(");
        }
        if (close < open) {
            solve(n, open, close+1, str +")");
        }
    }
}
