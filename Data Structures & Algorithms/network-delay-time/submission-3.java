class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.computeIfAbsent(time[0], k1 -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] min = new int[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[k] = 0;
        
        queue.add(new int[] {k, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[1] > min[current[0]])
                continue;  
            if(!map.containsKey(current[0])) continue;
            for (int[] next : map.getOrDefault(current[0], new ArrayList<>())) {
                int newDist = next[1] + current[1];
                if (newDist < min[next[0]]) {
                    min[next[0]] = newDist;
                    queue.add(new int[] {next[0], newDist});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (min[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, min[i]);
        }
        return max;
    }
}
