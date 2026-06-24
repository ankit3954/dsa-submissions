class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word){
        TrieNode curr = this;

        for(char c: word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }
}

class Solution {
        Set<String> res;
        boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            root.addWord(word);
        }

        int ROWS = board.length, COLUMNS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLUMNS];

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                dfs(i, j, board, root, "");
            }
        }

        return new ArrayList<>(res);
    }


    public void dfs(int r, int c, char[][] board, TrieNode node, String currWord) {
        if(
            r < 0 || c < 0 ||
            r >= board.length || c >= board[0].length ||
            visit[r][c] ||
            !node.children.containsKey(board[r][c])
        ){
            return;
        }

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        currWord += board[r][c];

        if(node.isWord){
            res.add(currWord);
        }

        dfs(r+1, c, board, node, currWord);
        dfs(r-1, c, board, node, currWord);
        dfs(r, c+1, board, node, currWord);
        dfs(r, c-1, board, node, currWord);

        visit[r][c] = false;
    }

}
