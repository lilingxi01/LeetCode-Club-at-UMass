// First alpha version by Lingxi.
class Solution {
    private int width;
    private int height;
    
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0)
            return 0;
        width = grid.length;
        height = grid[0].length;
        List<boolean[][]> islandTypes = new ArrayList();
        int[] curr;
        while ((curr = findNext(grid)).length != 0) {
            List<int[]> list = new ArrayList();
            helper(grid, curr[0], curr[1], list);
            boolean[][] currIslandType = getIslandType(list);
            // If this type exists, then we may not count it.
            if (!exist(currIslandType, islandTypes)) {
                islandTypes.add(currIslandType);
            }
        }
        return islandTypes.size();
    }
    
    private boolean exist(boolean[][] curr, List<boolean[][]> types) {
        for (boolean[][] b : types) {
            if (twoDimenEquals(curr, b)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean twoDimenEquals(boolean[][] a, boolean[][] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }
    
    private int[] findNext(int[][] grid) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] != 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    
    private void helper(int[][] grid, int x, int y, List<int[]> list) {
        if (x < 0 || y < 0 || x >= width || y >= height || grid[x][y] == 0) {
            return;
        }
        list.add(new int[]{x, y});
        grid[x][y] = 0;
        // Leak to adjacent coords.
        helper(grid, x-1, y, list);
        helper(grid, x+1, y, list);
        helper(grid, x, y-1, list);
        helper(grid, x, y+1, list);
    }
    
    private boolean[][] getIslandType(List<int[]> list) {
        int left = width;
        int right = 0;
        int top = height;
        int bottom = 0;
        for (int[] i : list) {
            left = Math.min(i[0], left);
            right = Math.max(i[0], right);
            top = Math.min(i[1], top);
            bottom = Math.max(i[1], bottom);
        }
        boolean[][] output = new boolean[right - left + 1][bottom - top + 1];
        for (int[] i : list) {
            output[i[0] - left][i[1] - top] = true;
        }
        return output;
    }
}
