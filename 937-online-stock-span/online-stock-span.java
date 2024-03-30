class StockSpanner {
    Stack<int[]> st=new Stack<>();
    public StockSpanner() {
    }
    
    public int next(int price) {
        int ans=1;
        // Stack<> temp=new Stack<>();
        while(!st.isEmpty()&&st.peek()[0]<=price){
            int[] a=st.pop();
            // temp.push(st.pop()[1]);
            ans=ans+a[1];
        }
        st.push(new int[]{price,ans});
        // while(temp.size()>0){
            // st.push(temp.pop());
        // }
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */