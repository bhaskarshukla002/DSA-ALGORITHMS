class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        int[] lps=new int[m];
        lps[0]=0;
        int t=0;
        int i=1;
        while(i<m)
        {
            if(needle.charAt(i)==needle.charAt(t)){
                t++;
                lps[i]=t;
                i++;
            }else{
                if(t!=0){
                    t=lps[t-1];
                }
                else{
                    lps[i]=t;
                    i++;
                }
            }
        }
        i=0;
        int j=0;
        while((n-i)>=(m-j)){
            if(needle.charAt(j)==haystack.charAt(i)){
                i++;
                j++;
            }
            if(j==m){
                return i-j;
            }
            else if(i<n&&haystack.charAt(i)!=needle.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i=i+1;
                }
            }            
        }
        return -1;
        
    }
}