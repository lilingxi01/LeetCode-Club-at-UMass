// By Lingxi
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.add(i);
            } else if (c[i] == ')') {
                if (stack.isEmpty()) {
                    c[i] = 0;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            c[stack.pop()] = 0;
        }
        return new String(c).replace("\u0000", "");
    }
}
