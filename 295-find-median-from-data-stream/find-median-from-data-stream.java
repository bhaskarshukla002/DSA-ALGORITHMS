class MedianFinder {

    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;
    private boolean even;

    public MedianFinder() {
        minHeap=new PriorityQueue<Integer>();
        maxHeap=new PriorityQueue<Integer>((a,b)->(b-a));
        even=true;
    }
    
    public void addNum(int num) {
        if(even){
            this.minHeap.add(num);
            this.maxHeap.add(this.minHeap.poll());
        } else{
            this.maxHeap.add(num);
            this.minHeap.add(this.maxHeap.poll());
        }
        even=!even;
    }
    
    public double findMedian() {
        if(!even) return this.maxHeap.peek();
        return (this.minHeap.peek()+this.maxHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */