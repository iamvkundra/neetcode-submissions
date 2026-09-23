class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int max = 0;
        int maxFreq = 0;
        while(end < s.length()) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.getOrDefault(ch, 0));
            while(end - start + 1 - maxFreq > k) {
                map.put(s.charAt(start), 
                map.getOrDefault(s.charAt(start), 0) - 1);
                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
                start++;
            }
            max = Math.max(max, end-start+1);
            end++;
        }
        return max;
    }
}

/**

A - 3
B - 1

1 > k


*/
