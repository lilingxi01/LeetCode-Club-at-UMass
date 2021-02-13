// Important: NOT the most efficient solution. A better solution is A* but I am still looking for a better way to implement that algorithm.
class Solution {
    private int width, height;
    private int result = -1;
    private Deque<Node> queue = new ArrayDeque();
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0)
            return -1;
        width = grid.length;
        height = grid[0].length;
        queue.addLast(new Node(new int[] {0, 0}, 1));
        
        Node curr;
        while ((curr = queue.pollFirst()) != null) {
            int x = curr.coord[0];
            int y = curr.coord[1];
            if (x < 0 || x >= width || y < 0 || y >= height || grid[x][y] == 1) {
                continue;
            }
            grid[x][y] = 1; // indicate as reached.
            if (x == width - 1 && y == height - 1) {
                result = result == -1 ? curr.length : Math.min(result, curr.length);
                continue;
            }
            queue.addLast(new Node(new int[] {x+1, y-1}, curr.length + 1));
            queue.addLast(new Node(new int[] {x+1, y+1}, curr.length + 1));
            queue.addLast(new Node(new int[] {x-1, y-1}, curr.length + 1));
            queue.addLast(new Node(new int[] {x-1, y+1}, curr.length + 1));
            queue.addLast(new Node(new int[] {x, y-1}, curr.length + 1));
            queue.addLast(new Node(new int[] {x, y+1}, curr.length + 1));
            queue.addLast(new Node(new int[] {x-1, y}, curr.length + 1));
            queue.addLast(new Node(new int[] {x+1, y}, curr.length + 1));
        }
        
        return result;
    }
    
    class Node {
        int[] coord;
        int length;
        public Node(int[] coord, int length) {
            this.coord = coord;
            this.length = length;
        }
    }
}
