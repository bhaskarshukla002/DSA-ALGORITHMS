class Solution {
    public int minPartitions(String n) {
        int len=n.length();
        int ans=0;
        for(int i=0;i<len;i++){
            if(n.charAt(i)>ans){
                ans=n.charAt(i);
            }
        }
        return ans-48;
    }
}