class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        HashSet<Integer> hs=new HashSet<>();
        int ans=1;
        for(int i:nums){
            hs.add(i);
        }
        for(int i:nums){
            if(!hs.contains(i-1)){
                int curr=1;
                int t=i+1;
                while(hs.contains(t++)){
                    curr++;
                }
                ans=Math.max(ans,curr);
            }
        }
        return ans;
    }
}