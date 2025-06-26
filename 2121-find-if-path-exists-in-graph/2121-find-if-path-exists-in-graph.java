class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            count[i] = 0;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, count);
        }

        return find(source, parent) == find(destination, parent);
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private void union(int a, int b, int[] parent, int[] count) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) return;

        if (count[rootA] < count[rootB]) {
            parent[rootA] = rootB;
        } else if (count[rootA] > count[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            count[rootA]++;
        }
    }
}
