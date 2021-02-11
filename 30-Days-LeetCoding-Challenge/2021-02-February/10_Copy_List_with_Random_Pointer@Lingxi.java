/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap();
    public Node copyRandomList(Node head) {
        Node node = head;
        while (node != null) {
            Node curr = map.getOrDefault(node, helper(head));
            curr.next = helper(node.next);
            curr.random = helper(node.random);
            node = node.next;
        }
        return map.getOrDefault(head, null);
    }
    private Node helper(Node node) {
        if (node == null)
            return null;
        if (!map.containsKey(node))
            map.put(node, new Node(node.val));
        return map.get(node);
    }
}
