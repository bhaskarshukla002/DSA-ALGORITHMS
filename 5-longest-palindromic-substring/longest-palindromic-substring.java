class Solution {
    public String longestPalindrome(String s) {
        // HashMap<String>
        // String ans="";
        int n=s.length();
        String ans="";
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String temp=s.substring(i,j);
                if(isPalindrome(temp)){
                    if(temp.length()>ans.length()){
                        ans=temp;
                    }
                }
            }
        }
        return ans;
    }
    boolean isPalindrome(String s){
        int l=0;
        int h=s.length()-1;
        while(l<=h){
            if(s.charAt(l)!=s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}