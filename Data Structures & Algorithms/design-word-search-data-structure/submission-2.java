class TrieNode{

    TrieNode[] children;
    boolean isTerminal;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.isTerminal = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        TrieNode child;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                child = new TrieNode();
                curr.children[c - 'a'] = child;
            }

            curr =  curr.children[c - 'a'];
        }
        curr.isTerminal = true;
    }

    public boolean search(String word) { 
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, TrieNode root){

        TrieNode curr = root;

        for(int i = j; i < word.length(); i++){
            char firstChar = word.charAt(i);

            if(firstChar == '.'){
                for(TrieNode child: curr.children){
                    if(child != null && dfs(word, i+1, child)){
                        return true;
                    }
                }    
                return false;
            }else{
                if(curr.children[firstChar - 'a'] == null){
                    return false;
                }

                curr =  curr.children[firstChar - 'a'];
            }

        }

        return curr.isTerminal;
    }


}
