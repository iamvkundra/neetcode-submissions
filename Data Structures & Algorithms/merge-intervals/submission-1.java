class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            if (list.isEmpty() || interval[0] > list.getLast()[1]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }
        int[][] result = new int[list.size()][];
        for (int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
