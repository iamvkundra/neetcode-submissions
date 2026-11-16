class Solution {
    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int[][] inDegree = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                int element = matrix[i][j];
                for (int[] direction : directions) {
                    int newX = direction[0] + i;
                    int newY = direction[1] + j;
                    if (!isValid(matrix, newX, newY)) {
                        continue;
                    }

                    if (matrix[i][j] < matrix[newX][newY]) {
                        inDegree[newX][newY]++;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (inDegree[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int newX = direction[0] + current[0];
                    int newY = direction[1] + current[1];

                    if (!isValid(matrix, newX, newY)) {
                        continue;
                    }
                    if (matrix[newX][newY] > matrix[current[0]][current[1]]) {
                        inDegree[newX][newY]--;
                        if (inDegree[newX][newY] == 0) {
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return false;
        }
        return true;
    }
}
