class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int length = s1.length();
        int size = map.size();
        int start = 0;
        int end = 0;
        while(end < s2.length()) {
            char ch = s2.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if (map.get(ch) == 0) {
                    size--;
                }
            }

            if (end-start+1 == length) {
                if (size == 0) {
                    return true;
                }
                if (map.containsKey(s2.charAt(start))) {
                    map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
                    if (map.get(s2.charAt(start)) == 1) {
                        size++;
                    }
                }
                start++;
            }
            end++;
        }
        return false;
    }
}
