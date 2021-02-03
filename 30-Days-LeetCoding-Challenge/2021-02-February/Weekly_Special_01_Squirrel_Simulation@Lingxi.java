class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int total = 0;
        int shortest = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            int sPath = path(squirrel, nut);
            int tPath = path(tree, nut);
            shortest = Math.min(shortest, sPath - tPath);
            total += tPath * 2;
        }
        return total + shortest;
    }
    
    // Compute the distance between two places.
    private int path(int[] obj1, int[] obj2) {
        return Math.abs(obj1[0] - obj2[0]) + Math.abs(obj1[1] - obj2[1]);
    }
}
