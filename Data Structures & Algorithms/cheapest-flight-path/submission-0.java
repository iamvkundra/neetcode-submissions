class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            map.computeIfAbsent(from, k1 -> new ArrayList<>()).add(new int[] {to, cost});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.add(new int[] {src, 0, 0});
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == dst) {
                return current[1];
            }
            if (current[2] >= minStops[current[0]] || current[2] > k) {
                continue;
            }

            minStops[current[0]] = current[2];
            for (int[] next : map.getOrDefault(current[0], new ArrayList<>())) {            int nextStop = next[0];
            int nextCost = next[1];
            queue.add(new int[]{nextStop, current[1] + nextCost, current[2] + 1});
            }
        }
        return -1;
    }
}
