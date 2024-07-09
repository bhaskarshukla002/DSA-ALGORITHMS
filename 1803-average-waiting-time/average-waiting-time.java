class Solution {
    public double averageWaitingTime(int[][] customers) {

        int currWaitTime=0;
        long waitTime=0;

        for(int i=0;i<customers.length;i++){
            int arv=customers[i][0];
            int timeReq=customers[i][1];
            currWaitTime=Math.max(currWaitTime,arv)+timeReq;
            waitTime=waitTime+currWaitTime-arv;
        }
        double ans=(double)waitTime/customers.length;
        return ans;
        
    }
}