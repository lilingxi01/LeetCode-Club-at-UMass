class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] mask = new int[graph.length];
        boolean output = true;
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 0)
                output = !output ? output : helper(graph, mask, i, 1);
        }
        return output;
    }
    
    // i: curr node, level: curr level
    private boolean helper(int[][] graph, int[] mask, int i, int level) {
        if (mask[i] != 0) {
            return (mask[i] % 2 == level % 2);
        } else {
            mask[i] = level;
            boolean output = true;
            for (int j : graph[i]) {
                output = !output ? output : helper(graph, mask, j, level + 1);
            }
            return output;
        }
    }
}
