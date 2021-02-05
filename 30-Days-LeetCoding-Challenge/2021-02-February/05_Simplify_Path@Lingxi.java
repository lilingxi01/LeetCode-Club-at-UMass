class Solution {
    public String simplifyPath(String path) {
        // Convert to List with split by "/".
        List<String> p = new ArrayList(Arrays.asList(path.split("/")));
        
        // Order the List.
        int index = 0;
        while (index < p.size()) {
            String curr = p.get(index);
            // Because we splited the string by "/" and did not handle multi-slashes cases.
            if (curr.equals("") || curr.equals(".")) {
                p.remove(index);
            } else if (curr.equals("..")) {
                if (index > 0) {
                    p.remove(index - 1);
                    index--;
                }
                p.remove(index);
            } else {
                index++;
            }
        }
        
        // Build path by ordered list.
        StringBuilder builder = new StringBuilder();
        for (String s : p) {
            builder.append("/");
            builder.append(s);
        }
        
        // Edge case: "/".
        if (p.size() == 0 && !path.equals("")) {
            builder.append("/");
        }
        return builder.toString();
    }
}
