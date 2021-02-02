class Solution {
    int minDis = Integer.MAX_VALUE;
    boolean start = false;
    public int shortestDistance(String[] words, String word1, String word2) {
        helper(words, 0, word1, word2, 0);
        return minDis;
    }
    
    private void helper(String[] words, int index, String currWord, String currObs, int lengthObs) {
        if (index >= words.length)
            return;
        if (words[index].equals(currWord)) {
            start = true;
            helper(words, index + 1, currWord, currObs, 0);
            return;
        }
        if (words[index].equals(currObs)) {
            if (start)
                minDis = Math.min(minDis, lengthObs + 1);
            start = true;
            helper(words, index + 1, currObs, currWord, 0);
            return;
        }
        helper(words, index + 1, currWord, currObs, lengthObs + 1);
    }
}
