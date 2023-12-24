class Solution {
    public int minOperations(String s) {
        int ans=0;
        int l=s.length();
        for(int i=0;i<l;i++){
            if(i%2==0&&s.charAt(i)=='1') ans++;
            if(i%2==1&&s.charAt(i)=='0') ans++;
        }
        return Math.min(ans,l-ans);
    }
}