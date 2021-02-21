class Solution {
    Map<Character, Integer> map = new HashMap();
    
    public int romanToInt(String s) {
        init();
        
        char[] c = s.toCharArray();
        int lastTime = 0;
        int currTime = 0;
        int result = map.get(c[0]);
        
        for (int i = 1; i < c.length; i++) {
            lastTime = map.get(c[i-1]);
            currTime = map.get(c[i]);
            result += currTime;
            if (currTime > lastTime) {
                result -= 2 * lastTime;
            }
        }
        
        return result;
    }
    
    private void init() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}
