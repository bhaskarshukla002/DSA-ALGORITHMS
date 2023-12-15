class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int buy=prices[0];
        for(int sell:prices){
            if(buy>sell)
            buy=sell;
            else{
            int profit=sell-buy;
            maxProfit=profit+maxProfit;
            buy=sell;
            }
        }
        return maxProfit;
    }
}