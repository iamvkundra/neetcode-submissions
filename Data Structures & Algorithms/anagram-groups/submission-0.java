class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] data = s.toCharArray();
            Arrays.sort(data);
            String value = String.valueOf(data);
            map.computeIfAbsent(value, k -> new ArrayList<>()).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> v : map.values()) {
            result.add(v);
        }
        return result;
    }
}
