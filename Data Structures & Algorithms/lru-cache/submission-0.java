class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }

        if (capacity == map.size()) {
            remove(tail.prev);
        }

        Node node = new Node(key, value);
        add(node);
    }

    private void add(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
