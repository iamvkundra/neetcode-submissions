class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String s1 : wordDict) {
            set.add(s1);
        }
        Map<Integer, Boolean> map = new HashMap<>();
        return solve(s, set, 0, map);
    }

    private boolean solve(String s, Set<String> set, int index, Map<Integer, Boolean> map) {
        if (index >= s.length()) {
            return true;
        }

        if (map.containsKey(index)) {
            return map.get(index);
        }
        boolean flag = false;
        for (int i=index; i<s.length(); i++) {
            String sub = s.substring(index, i+1);
            if (set.contains(sub) && solve(s, set, i+1, map)) {
                flag = true;
            }
        }

        map.put(index, flag);
        return flag;
    }
}
