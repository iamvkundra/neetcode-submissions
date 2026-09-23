class Solution {
    public int romanToInt(String s) {
        int sum =0;
        for (int i=0; i<s.length(); i++) {
            sum += get(s.charAt(i));
            if (i-1 >=0) {
                if ((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i-1) == 'I') {
                    sum -= 2 * get(s.charAt(i-1));
                } else if ((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i-1) == 'X') {
                    sum -= 2 * get(s.charAt(i-1));
                } else if ((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i-1) == 'C') {
                    sum -= 2 * get(s.charAt(i-1));;
                }
            }
        }
        return sum;
    }

    private int get(char n) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map.get(n);
    }
}