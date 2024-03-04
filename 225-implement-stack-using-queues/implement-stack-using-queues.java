class MyStack {
    // private final Queue<Integer> queue1=new LinkedList<Integer>();
    // private final Queue<Integer> queue2=new LinkedList<Integer>();
    // private int top;
    // public MyStack() {
        
    // }
    
    // public void push(int x) {
    //     queue1.offer(x);
    //     top=x;
    // }
    
    // public int pop() {
    //     while(queue1.size()>1)
    //     {
    //         top=queue1.poll();
    //         queue2.offer(top);
    //     }
    //     int val=queue1.poll();
    //     while(!queue2.isEmpty()){
    //         queue1.offer(queue2.poll());
    //     }
    //     return val;
    // }
    
    // public int top() {
    //     return top;
    // }
    
    // public boolean empty() {
    //     return queue1.isEmpty();
    // }

    private final Queue<Integer> queue1=new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        queue1.offer(x);
        // int i=queue1.size()-1;
        for(int i=0;i<queue1.size()-1;i++){
            queue1.offer(queue1.remove());
        }
    }
    
    public int pop() {
        return queue1.remove();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */