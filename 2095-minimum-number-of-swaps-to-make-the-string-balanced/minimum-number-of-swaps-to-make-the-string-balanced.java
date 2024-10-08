class Solution {
    public int minSwaps(String s) {
        int unbalanced=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='['){
                st.push(c);
            }else{
                if(!st.isEmpty()) st.pop();
                else unbalanced++;
            }
        }    
        return (unbalanced+1)/2;
    } 
}