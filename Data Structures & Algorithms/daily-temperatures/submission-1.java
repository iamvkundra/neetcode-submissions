class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temp.length];
        for (int i=temp.length-1; i>=0; i--) {
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                if (temp[stack.peek()] > temp[i]) {
                    result[i] = 1;
                } else {
                    while(!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        result[i] = 0;
                    } else {
                        result[i] = stack.peek()-i;
                    }
                }
            }
            stack.push(i);
        }
        return result;
    }
}
