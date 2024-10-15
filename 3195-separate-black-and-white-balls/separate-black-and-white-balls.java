class Solution {
    public long minimumSteps(String s) {
        int bcount=0;
        long ans=0;
        for(char c:s.toCharArray()){
            if(c=='0'){
                ans+=(long)bcount;
            }else{
                bcount++;
            }

        }
        return ans;
        
    }
}