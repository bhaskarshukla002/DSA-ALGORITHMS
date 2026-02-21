class Solution {
    public String removeOuterParentheses(String s) {
        int n= s.length();
        int i=0;
        String r="";
        int count=0;
        while(i<n){
            char c=s.charAt(i);
            if(c=='('){
                count++;
                if(count>=2){
                r=r+c;
                }
            } else{
                if(count>=2){
                    r=r+c;
                }
                count--;
                
            }
            
            i++;
        }
        return r;
    }
}