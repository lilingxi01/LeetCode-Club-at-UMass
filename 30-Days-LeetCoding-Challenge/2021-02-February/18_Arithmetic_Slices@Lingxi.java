// By Lingxi
class Solution {
    public int numberOfArithmeticSlices(int[] array) {
        if (array.length < 3)
            return 0;
        int count = 0;
        int acc = 1;
        int step = array[1] - array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i-1] == step) {
                // continue to accumulate
                acc += 1;
            } else {
                // stop accumulate and settle the values
                for (int j = acc; j >= 3; j--)
                    count += acc - j + 1;
                acc = 2;
                step = array[i] - array[i-1];
            }
        }
        for (int j = acc; j >= 3; j--)
            count += acc - j + 1;
        return count;
    }
}
