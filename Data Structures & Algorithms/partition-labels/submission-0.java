class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int far = map.get(s.charAt(0));
        for (end = 0; end < s.length(); end++) {
            if (end > far) {
                result.add(end-start);
                start = end;
                far = map.get(s.charAt(start));
            }
            far = Math.max(far, map.get(s.charAt(end)));
        }
        result.add(end-start);
        return result;
    }
}
