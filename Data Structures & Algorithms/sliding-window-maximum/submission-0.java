class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        List<Integer> list = new ArrayList<>();
        int start = 0;
        for (int i=0; i<nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            if (i-start+1 >= k) {
                while(!queue.isEmpty() && queue.peek()[1] < start) {
                    queue.poll();
                }
                list.add(queue.peek()[0]);
                start++;
            }
        }
        int[] r = new int[list.size()];
        for (int i=0; i<r.length; i++) {
            r[i] = list.get(i);
        }
        return r;
    }
}
