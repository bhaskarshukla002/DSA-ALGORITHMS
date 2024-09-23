class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        int dp[]=new int[n+1];
        HashSet<String> dicSet=new HashSet<>(Arrays.asList(dictionary));
        for(int start=n-1;start>=0;start--){
            dp[start]=dp[start+1]+1;
            for(int end=start;end<n;end++){
                String curr=s.substring(start,end+1);
                if(dicSet.contains(curr)){
                    dp[start]=Math.min(dp[start],dp[end+1]);
                }
            }
        }
        return dp[0];
    }
}