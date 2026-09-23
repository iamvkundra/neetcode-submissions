class Solution {
    Set<String> result = new HashSet<>();
    private TrieNode root = new TrieNode();
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        addWords(words);
        
        TrieNode node = root;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (node.children[board[i][j] - 'a'] != null) {
                    search(board, i, j, new StringBuilder(), node);
                }
            }
        }
        return new ArrayList<>(result);
    }
    
    private void search(char[][] board, int i, int j, StringBuilder sb, TrieNode node) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '%' || node.children[board[i][j] - 'a'] == null
        ) {
            return; 
        }

        char data = board[i][j];
        node = node.children[data - 'a'];

        board[i][j] = '%';
        sb.append(data);

        if (node.isLeaf) {
            result.add(sb.toString());
        }

        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            search(board, newX, newY, sb, node);
        }

        board[i][j] = data;
        sb.deleteCharAt(sb.length()-1);
    }
    private void addWords(String[] words) {
        for (String s : words) {
            add(root, s);
        }
    }

    private void add(TrieNode root, String s) {
        if (s.length() == 0) {
            root.isLeaf = true;
            return;
        }

        int index = s.charAt(0) - 'a';
        if (root.children[index] == null) {
            root.children[index] = new TrieNode();
        }
        add(root.children[index], s.substring(1));
    }
    
}
class TrieNode {
    TrieNode[] children;
    boolean isLeaf;
    public TrieNode() {
        this.children = new TrieNode[26];
        this.isLeaf = false;
    }
}
