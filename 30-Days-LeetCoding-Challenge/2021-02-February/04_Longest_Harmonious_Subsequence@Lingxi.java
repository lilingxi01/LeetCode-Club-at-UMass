class Solution {
    public int findLHS(int[] nums) {
        // Using the sort.
        Arrays.sort(nums);
        int output = 0;
        int lastCount = -1;
        int count = 0;
        int curr = nums[0];
        for (int i : nums) {
            if (i == curr) {
                count += 1;
            } else {
                if (lastCount != -1)
                    output = Math.max(output, lastCount + count);
                lastCount = i - curr == 1 ? count : -1;
                count = 1;
                curr = i;
            }
        }
        return lastCount != -1 ? Math.max(output, lastCount + count) : output;
    }
}
