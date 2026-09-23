class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind union = new UnionFind(edges.length);

        for (int[] ed : edges) {
            if (!union.union(ed[0]-1, ed[1] - 1)) {
                return new int[]{ed[0], ed[1]};
            }
        }
        return new int[]{};
    }
}
class UnionFind {
    int[] parent;
    public UnionFind(int n) {
        this.parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

        public int find(int x) {
            if (parent[x] == x) {
                return parent[x];
            }

            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int x1 = find(x);
            int y2 = find(y);

            if (x1 == y2) {
                return false;
            }
            parent[x1] = y2;
            return true;
        }
}
