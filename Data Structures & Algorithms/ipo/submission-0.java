class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Node> list = new ArrayList<>();
        for (int i=0; i<profits.length; i++) {
            list.add(new Node(profits[i], capital[i]));
        }

        Collections.sort(list, (a, b) -> a.capital - b.capital);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int end = 0;
        while (k-- > 0) {
            while(end < list.size() && list.get(end).capital <= w) {
                queue.add(list.get(end).profit);
                end++;
            }
            if (queue.isEmpty()) {
                break;
            }
            w += queue.poll();
        }
        return w;

    }
    class Node {
        int profit;
        int capital;
        public Node(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}