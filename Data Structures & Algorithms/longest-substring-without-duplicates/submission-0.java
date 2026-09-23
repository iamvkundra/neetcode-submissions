class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(start <= end && map.getOrDefault(ch, 0) > 1) {
                map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
                start++;
            }
            max = Math.max(max, end-start+1);
            end++;
        }
        return max;
    }
}
