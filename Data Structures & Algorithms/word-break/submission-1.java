class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word : wordDict) {
            set.add(word);
        }

        return solve(s, set, 0);
    }
    Map<Integer, Boolean> map = new HashMap<>();
    private boolean solve(String s, Set<String> set, int index) {
        if (index >= s.length()) {
            return true;
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }

        boolean flag = false;
        for (int i=index; i<s.length(); i++) {
            String temp = s.substring(index, i+1);
            if (set.contains(temp) && solve(s, set, i+1)) {
                flag = true;
            }
        }
        map.put(index, flag);
        return flag;
    }
}
