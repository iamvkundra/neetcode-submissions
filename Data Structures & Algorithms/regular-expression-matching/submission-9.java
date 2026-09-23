class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isMatch(String s, String p) {
        
        return solve(s, p);
    }

    private boolean solve(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        String key = s + " "+p;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean flag = false;
        if ( s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            flag = true;
        }

        if (p.length() >= 2 && p.charAt(1) == '*') {
            flag =  flag && (solve(s.substring(1), p)) || solve(s, p.substring(2));
        } else {
            flag = flag && solve(s.substring(1), p.substring(1));
        }
        map.put(key, flag);
        return flag;
    }
}
