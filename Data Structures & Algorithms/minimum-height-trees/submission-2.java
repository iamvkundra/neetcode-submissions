class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
    return List.of(0);
}   
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[n];

        for (int[] ed : edges) {
            map.computeIfAbsent(ed[0], k -> new ArrayList<>()).add(ed[1]);
            map.computeIfAbsent(ed[1], k -> new ArrayList<>()).add(ed[0]);

            inDegree[ed[1]]++;
            inDegree[ed[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int remainingNodes = n;

        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 1) {
                queue.add(i);
            }
        }

        while(remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;
            for (int i=0; i<size; i++) {
                int current = queue.poll();
                for (int next : map.getOrDefault(current, new ArrayList<>())) {
                    inDegree[next]--;
                    if (inDegree[next] == 1) {
                        queue.add(next);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }
}

/**
[0, 2, 0, 0, 0]

*/