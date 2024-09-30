class CustomStack {

    int[] arr;
    int size;
    int cap;
    int top;

    public CustomStack(int maxSize) {
        arr=new int[maxSize];
        size=0;
        cap=maxSize-1;
        top=-1;
    }
    
    public void push(int x) {
        if(!isFull()){
            arr[++top]=x;
        }
    }
    
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        return arr[top--];
        
    }

    boolean isFull(){
        if(top==cap){
            return true;
        }
        return false;
    }

    boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }

    
    public void increment(int k, int val) {
        int con=Math.min(k,top+1);
        for(int i=0;i<con;i++){
            arr[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */