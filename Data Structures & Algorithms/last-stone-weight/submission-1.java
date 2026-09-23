class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int in : stones) {
            queue.add(in);
        }
        while(queue.size() > 1) {
            int popped1 = queue.poll();
            int popped2 = queue.poll();
            if (popped1 == popped2) continue;
            if (popped1 != popped2) {
                queue.add(Math.abs(popped2-popped1));
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
