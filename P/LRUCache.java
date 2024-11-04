class LRUCache 
{
    class Node
    {
        Node next, prev;
        int key, value;
        Node (int k, int v) { key = v; value = v; }
    }

    private HashMap<Integer, Node> map;
    private  Node head, tail;
    private int capacity;

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
        deleteNode(node);
        putInFront(node);
        return node.value;
    }
    
    public void put(int key, int value) 
    {
        if (map.containsKey(key))
        {
            deleteNode(map.get(key));
        }

        else if (map.size() == capacity)
        {
            deleteNode(tail.prev);
        }

        putInFront(new Node(key, value));
    }

    public void deleteNode(Node node)
    {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void putInFront(Node node)
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
