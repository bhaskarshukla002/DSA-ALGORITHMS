class MinStack {
    List<Integer> lastMin=new ArrayList<>();
    Stack<Integer> st=new Stack<>(); 
    public MinStack() {
    }
    
    public void push(int val) {
        st.push(val);
        if(lastMin.isEmpty()){
            lastMin.add(val);
        }else
        lastMin.add(Math.min(val,lastMin.get(lastMin.size()-1)));
    }
    
    public void pop() {
        if(!st.isEmpty()){
        st.pop();
        lastMin.remove(lastMin.size()-1);
        }
    }
    
    public int top() {
        if(!st.isEmpty())
        return st.peek();
        return -1;
    }
    
    public int getMin() {
        if(!st.isEmpty())
        return lastMin.get(lastMin.size()-1);
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */