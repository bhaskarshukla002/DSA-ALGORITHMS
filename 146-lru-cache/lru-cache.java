class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Node head=new Node(0,0),tail=new Node(0,0); 
    HashMap<Integer,Node> hm=new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    void insert(Node node){
        hm.put(node.key,node);
        head.next.prev=node;
        node.next=head.next;
        node.prev=head;
        head.next=node;
    }
    void delete(Node node){
        hm.remove(node.key);
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    public int get(int key) {
        if(hm.containsKey(key)){
            Node node=hm.get(key);
            delete(node);
            insert(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
       if(hm.containsKey(key)){
            delete(hm.get(key));
        }
        if(hm.size()==capacity){
            delete(tail.prev);
        }
        insert(new Node(key,value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */