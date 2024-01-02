class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int ans=0;
        for(int i:nums){
            hs.add(i);
        }
        for(int i:nums){
            if(!hs.contains(i-1)){
                int curr=0;
                int t=i;
                while(hs.contains(t++)){
                    curr++;
                }
                ans=Math.max(ans,curr);
            }
        }
        return ans;
    }
}