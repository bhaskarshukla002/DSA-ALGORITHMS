class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int[] dp2=new int[n+1];
        Arrays.fill(dp2,-1);
        return Math.max(recur(n-2,0,nums,dp),recur(n-1,1,nums,dp2));
    }

    int recur(int ind,int first,int nums[],int dp[]){
        if(ind<first) return 0;
        if(ind==first) return nums[ind];
        if(dp[ind]!=-1) return dp[ind];
        dp[ind]=Math.max(nums[ind]+recur(ind-2,first,nums,dp),recur(ind-1,first,nums,dp));
        return dp[ind];
    }
}