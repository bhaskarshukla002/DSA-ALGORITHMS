class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        // Arrays.fill(dp,-1);
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int pick=nums[i];
            if(i>1) pick+=dp[i-2];
            int nopick=0+dp[i-1];
            dp[i]=Math.max(pick,nopick);
        }
        return dp[nums.length-1];

        // return recur(nums.length-1,nums,dp);
    }

    int recur(int ind,int nums[],int dp[]){
        if(ind<0) return 0;
        if(ind==0) return nums[ind];
        if(dp[ind]!=-1) return dp[ind];
        dp[ind]=Math.max(nums[ind]+recur(ind-2,nums,dp),recur(ind-1,nums,dp));
        return dp[ind];

    }
}