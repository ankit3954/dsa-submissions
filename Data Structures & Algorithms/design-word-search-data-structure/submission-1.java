class TrieNode {
    char data;
    TrieNode[] children;
    boolean isTerminal;

    public TrieNode(char data) {
        this.data = data;
        this.children = new TrieNode[26];
        this.isTerminal = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode('/');
    }

    public void addWord(String word) {
        insertHelper(root, word);
    }

    private void insertHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }
        int index = word.charAt(0) - 'a';
        TrieNode child;
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }
        insertHelper(child, word.substring(1));
    }

    public boolean search(String word) {
        // Removed the unnecessary 3rd index tracker parameter
        return searchHelper(root, word); 
    }

    private boolean searchHelper(TrieNode root, String word) {
        // Base Case 1: If we fall off the tree, this path is invalid
        if (root == null) {
            return false;
        }
        // Base Case 2: When string is fully consumed, check if it forms a complete word
        if (word.length() == 0) {
            return root.isTerminal;
        }

        char firstChar = word.charAt(0);

        // Case A: Handle wildcard match
        if (firstChar == '.') {
            for (int i = 0; i < 26; i++) {
                // Try to find any valid path downwards
                if (searchHelper(root.children[i], word.substring(1))) {
                    return true;
                }
            }
            return false; // None of the 26 branches matched the rest of the string
        } 
        
        // Case B: Handle exact character match
        else {
            int index = firstChar - 'a';
            return searchHelper(root.children[index], word.substring(1));
        }
    }
}
