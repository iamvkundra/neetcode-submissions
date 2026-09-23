class Solution {
    class Node {
        char ch;
        int count;
        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().ch != ch) {
                stack.push(new Node(ch, 1));
            } else {
                stack.peek().count += 1;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Node node : stack) {
            while(node.count -- > 0) {
                sb.append(node.ch);
            }
        }
        return sb.toString();
    }
}
/*
aa

*/