 class TrieNode{
        char data;
        TrieNode[] children;
        boolean isTerminal;

        public TrieNode(char data){
            this.data = data;
            children = new TrieNode[26];
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            isTerminal = false;
        }
    }

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode('/');
    }

    public void insert(String word) {
        insertHelper(root, word);
    }

    public void insertHelper(TrieNode root, String word) {
        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(0) - 'a';
        TrieNode child;
        if(root.children[index] != null){
            child = root.children[index];
        }else{
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        insertHelper(child, word.substring(1));
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }

    public boolean searchHelper(TrieNode root, String word){
        if(word.length() == 0){
            if(root.isTerminal){
                return true;
            }

            return false;
        }

        int index = word.charAt(0) - 'a';
        TrieNode child;

        if(root.children[index] != null && root.children[index].data == word.charAt(0)){
            child = root.children[index];
            return searchHelper(child, word.substring(1));
        }else{
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        return startsWithHelper(root, prefix);
    }
    public boolean startsWithHelper(TrieNode root, String prefix) {
        if(prefix.length() == 0){
            return true;
        }

        int index = prefix.charAt(0) - 'a';
        TrieNode child;

        if(root.children[index] != null && root.children[index].data == prefix.charAt(0)){
            child = root.children[index];
            return startsWithHelper(child, prefix.substring(1));
        }else{
            return false;
        }
    }

   
}
