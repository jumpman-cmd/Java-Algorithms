class LRUCache 
{
    class Node
    {
        Node next, prev;
        int key, value;
        Node(int k, int v) { key = k; value = v; }
    }
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        tail.prev = head;
        head.next = tail;    
    }
    
    public int get(int key)
    {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertAtFront(node);

        return node.value;
    }
    
    public void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            remove(map.get(key));
        }

        else if (map.size() == capacity)
        {
            remove(tail.prev);
        }

        insertAtFront(new Node(key, value));
    }

    public void remove(Node node)
    {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtFront(Node node)
    {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
