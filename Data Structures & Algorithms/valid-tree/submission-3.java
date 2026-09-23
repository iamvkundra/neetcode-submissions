class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        UnionFind u = new UnionFind(n+1);
        for (int[] ed : edges) {
            if (!u.union(ed[0], ed[1])) {
                return false;
            }
        }
        return true;
    }
}
class UnionFind {
    int[] parent;
    public UnionFind(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
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
