class Solution {
    public String reverseWords(String s) {
        // s=s.trim();
        int n = s.length();
        String temp="";
        String ans="";
        for (int i = 0; i < n ; i++){
            char c=s.charAt(i);
            if(s.charAt(i)!=' '){
                temp=temp+c;
            }else if(c==' '&&!temp.equals("")){
                if(!ans.equals("")){
                    ans=temp+" "+ans;
                }else{
                    ans=temp;
                }
                temp="";
            }
        }

        if( !temp.equals("")){
            if(!ans.equals("")){
                ans=temp+" "+ans;
            }else{
                ans=temp;
            }
        }

        return ans;
        
    }
}