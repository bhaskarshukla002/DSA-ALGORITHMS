class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        Set<Integer> hs=new HashSet<>();
        int ans=1;
        for(int i=0;i<n;i++){
            hs.add(nums[i]);
        }
        for(int i:nums){
            if(!hs.contains(i-1)){
                int curr=1;
                int t=i;
                while(hs.contains(t+1)){
                    t=t+1;
                    curr=curr+1;
                }
                ans=Math.max(ans,curr);
            }
        }
        return ans;
    }
}