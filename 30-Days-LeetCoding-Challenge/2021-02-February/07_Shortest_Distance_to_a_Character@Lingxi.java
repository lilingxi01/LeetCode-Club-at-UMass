class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] list = s.toCharArray();
        int[] output = new int[list.length];
        helper(list, 0, c, list.length, output);
        return output;
    }
    
    private int helper(char[] list, int i, char c, int last, int[] output) {
        if (i >= list.length)
            return list.length; // Return a maximum value.
        if (list[i] == c)
            last = 0;
        int next = helper(list, i + 1, c, last + 1, output);
        if (list[i] == c)
            next = 0;
        int curr = Math.min(last, next);
        output[i] = curr;
        return next + 1;
    }
}
