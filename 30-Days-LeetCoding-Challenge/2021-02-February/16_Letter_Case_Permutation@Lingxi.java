class Solution {
    List<StringBuilder> builders = new ArrayList();
    
    public List<String> letterCasePermutation(String S) {
        builders.add(new StringBuilder());
        char[] c = S.toCharArray();
        for (int i = 0; i < c.length; i++) {
            add(c[i]);
        }
        
        List<String> output = new ArrayList();
        for (StringBuilder builder : builders) {
            output.add(builder.toString());
        }
        return output;
    }
    
    public void add(char c) {
        if (Character.isDigit(c)) {
            for (int i = 0; i < builders.size(); i++) {
                builders.get(i).append(c);
            }
        } else {
            int size = builders.size();
            for (int i = 0; i < size; i++) {
                builders.add((new StringBuilder(builders.get(i))).append(Character.toUpperCase(c)));
                builders.get(i).append(Character.toLowerCase(c));
            }
        }
    }
}

/**
// A much more efficient solution.
// From Internet.
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList();
        char[] ch = S.toCharArray();
        permute(ch, result, 0);
        return result;
    }
    
    public void permute(char[] ch, List<String> result, int index) {
        result.add(new String(ch));
        for (int i = index; i < ch.length; i++) {
            char c = ch[i];
            if (Character.isLetter(c)) {
                ch[i] = getModifiedLetter(c);
                permute(ch, result, i+1);
                ch[i] = c;
            }
        }
    }
    
    public char getModifiedLetter(char c) {
        return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
    }
}
*/
