class Solution {
    public int compareVersion(String s1, String s2) {
        int ans=0,i=0,j=0;
        int len1=s1.length();
        int len2=s2.length();
        while(i<len1||j<len2){
            int v1=0;
            while(i<len1&&s1.charAt(i)!='.'){
                v1=v1*10+s1.charAt(i)-'0';
                i++;
            }
            ++i;
            int v2=0;
            while(j<len2&&s2.charAt(j)!='.'){
                v2=v2*10+s2.charAt(j)-'0';
                j++;
            }
            ++j;
            if(v1!=v2){
                return v1>v2?1:-1;
            }           
        }
        return 0;
    }
}