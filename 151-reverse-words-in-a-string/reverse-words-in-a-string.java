class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        int i=s.length()-1;
        String res="";
        while(i>=0){
            // char c=s.chatAt(i);
            String temp="";
            while(i>=0 && s.charAt(i)==' ' ){
                i--;
            }
            while(i>=0 && s.charAt(i)!=' '){
                temp=s.charAt(i)+temp;
                i--;
                if(i>=0 && s.charAt(i)==' '){
                    temp=temp+' ';
                }
            }
            
            res=res+temp;
            i--;
        }
        return res;
        
    }
}