class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int unbalanced=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                st.push(c);
            }else{
                if(st.isEmpty()){
                    unbalanced++;
                }else{
                    st.pop();
                }
            }
        }
        return unbalanced+st.size(); 
        
    }
}