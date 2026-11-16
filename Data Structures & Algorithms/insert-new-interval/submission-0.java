class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> queue = new LinkedList<>();
        int index = 0;
        while(index < intervals.length && intervals[index][0] <= newInterval[0]) {
            queue.add(intervals[index]);
            index++;
        }

        if (queue.isEmpty() || queue.getLast()[1] < newInterval[0]) {
            queue.add(newInterval);
        } else {
            queue.getLast()[1] = Math.max(queue.getLast()[1], newInterval[1]);
        }

        while(index < intervals.length) {
            if (queue.isEmpty() || queue.getLast()[1] < intervals[index][0]) {
                queue.add(intervals[index]);
            } else {
                queue.getLast()[1] = Math.max(queue.getLast()[1], intervals[index][1]);
            }
            index++;
        }

        return queue.toArray(new int[queue.size()][2]);
    }
}
