class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.computeIfAbsent(time[0], k1 -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        int[] min = new int[n+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[k] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k, 0});
        int temp = n;
        while(!queue.isEmpty()) {
            int size = queue.size();
            temp -= size;
            for (int i=0; i<size; i++) {
                int[] current = queue.poll();
                if (current[1] > min[current[0]]) continue;
                if (!map.containsKey(current[0])) continue;
                for (int[] next : map.get(current[0])) {
                    int newCost = current[1] + next[1];
                    if (newCost < min[next[0]]) {
                        min[next[0]] = newCost;
                        queue.add(new int[]{next[0], newCost});
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (min[i] == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, min[i]);
        }

        return answer;
    }
}
