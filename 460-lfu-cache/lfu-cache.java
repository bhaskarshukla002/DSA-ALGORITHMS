class LFUCache {
    class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency=1;
        }
    }

    class DoubleLinkedList {
        int size;
        Node head=new Node(0,0);
        Node tail=new Node(0,0);
        public DoubleLinkedList() {
            head.next=tail;
            tail.prev=head;
            size=0;
        }

        private void insert(Node node) {
            // hm.put(node.key, node);
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }

        private void delete(Node node) {
            // hm.remove(node.key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }
    }

    // Node head=new Node(0,0),tail=new Node(0,0);
    HashMap<Integer, Node> cache = new HashMap<>();
    HashMap<Integer, DoubleLinkedList> frequency = new HashMap<>();
    int capacity;
    int currSize;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        currSize = 0;
        minFreq = 0;
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node=cache.get(key);
            updateNode(node);
            return node.value;
        } else {
            return -1;
        }
    }
    void updateNode(Node node){
        int freq=node.frequency;
        DoubleLinkedList dll=frequency.get(freq);
        dll.delete(node);
        if(minFreq==freq&&dll.size==0)
        minFreq++;
        node.frequency=freq+1;
        dll=frequency.getOrDefault(freq+1,new DoubleLinkedList());
        dll.insert(node);
        frequency.put(freq+1,dll);
    }
    public void put(int key, int value) {
        if(capacity==0)
        return;
        if (cache.containsKey(key)) {
            Node node=cache.get(key);
            node.value=value;
            updateNode(node);
        }else{
            currSize++;
            if(currSize>capacity){
                DoubleLinkedList dll=frequency.get(minFreq);
                cache.remove(dll.tail.prev.key);
                dll.delete(dll.tail.prev);
                currSize--;   
            }

            minFreq=1;
            Node node=new Node(key,value);
            DoubleLinkedList dll=frequency.getOrDefault(minFreq,new DoubleLinkedList());
            dll.insert(node);
            frequency.put(1,dll);
            cache.put(node.key, node);
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */