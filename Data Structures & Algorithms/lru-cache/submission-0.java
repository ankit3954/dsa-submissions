class Node{
    int val;
    int key;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.val = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    HashMap<Integer, Node> cache;
    int cap;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        cache.put(key, newNode);

        if(cache.size() > this.cap){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        node.next = this.right;
        node.prev = prev;
        this.right.prev = node;
        prev.next = node;
    }
}
