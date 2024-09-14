class Solution {
    public int longestSubarray(int[] nums) {
        int val=0;
        int max=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(val<nums[i]){
                val=nums[i];
                ans = max =0 ;
            }
            if(val==nums[i]){
                max++;
            }
            else{
                max=0;
            }
            ans=Math.max(ans,max);

        }
        return ans;
        
    }
}