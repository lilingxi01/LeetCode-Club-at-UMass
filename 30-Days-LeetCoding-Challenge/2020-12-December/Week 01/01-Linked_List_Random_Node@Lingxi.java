// This is not the most efficient solution.
class Solution {
    Map<Integer, Integer> map = new HashMap();

    public Solution(ListNode head) {
        int curr = 0;
        while (head != null) {
            map.put(curr, head.val);
            head = head.next;
            curr++;
        }
    }

    public int getRandom() {
        int target = (int) (Math.random() * map.size());
        return map.get(target);
    }
}
