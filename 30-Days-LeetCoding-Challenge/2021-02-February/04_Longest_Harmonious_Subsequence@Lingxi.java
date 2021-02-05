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

/**
    Another approach:
        class Solution {
            public int findLHS(int[] nums) {
                Map<Integer, Integer> map = new HashMap();
                for (int i : nums) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
                int output = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int key = entry.getKey();
                    if (map.containsKey(key + 1)) {
                        output = Math.max(output, map.get(key) + map.get(key + 1));
                    }
                }
                return output;
            }
        }
*/
