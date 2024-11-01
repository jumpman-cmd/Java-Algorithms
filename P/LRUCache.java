class LRUCache 
{
    class Node
    {
        int key, value;
        Node next, prev;
        Node (int k, int v) { key = k; value = v; }
    }

    private HashMap<Integer, Node> map;
    private Node head, tail;
    private int capacity;

    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;    
    }
    
    public int get(int key) 
    {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        InsertToFront(node);
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

        InsertToFront(new Node(key, value));
    }

    private void remove(Node node)
    {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void InsertToFront(Node node)
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
