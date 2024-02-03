class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return memoization(arr,k,0);
    }
    int memoization(int[] arr,int k,int start){
        if(start>=arr.length){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int currMax=0;
        int ans=0;
        int end=Math.min(arr.length,start+k);
        for(int i=start;i<end;i++){
            currMax=Math.max(currMax,arr[i]);
            ans=Math.max(ans,currMax*(i-start+1)+memoization(arr,k,i+1));
        }
        return dp[start]=ans;
    }
}