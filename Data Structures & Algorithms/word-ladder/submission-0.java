class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String s1 : wordList) {
            set.add(s1);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        Set<String> visited = new HashSet<>();
        set.add(beginWord);

        int counter =0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return counter+1;
                }

                for (int iI=0; iI<current.length(); iI++) {
                    StringBuilder sb = new StringBuilder(current);
                    char pre = sb.charAt(iI);
                    for (char ch= 'a'; ch <= 'z'; ch++) {
                        sb.setCharAt(iI, ch);
                        if (!visited.contains(sb.toString()) && set.contains(sb.toString())) {
                            queue.add(sb.toString());
                            visited.add(sb.toString());
                        }
                    }
                    sb.setCharAt(iI, pre);
                }
            }
            counter++;
        }
        return 0;
    }
}
