class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int []a=new int[n];
        Stack<Integer> st=new Stack();
        st.add(0);
        for(int i=1;i<n;i++){
            while(!st.empty()&&temperatures[st.peek()]<temperatures[i]){
                int idx=st.pop();
                int d=i-idx;
                a[idx]=d;
            }
            st.push(i);
        }
        return a;
    }
}