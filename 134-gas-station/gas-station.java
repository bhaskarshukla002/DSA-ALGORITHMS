class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0;
        int n=cost.length;
        int s=0;
        int totalt=0;
        for(int i=0;i<n;i++){
            total=total+(gas[i]-cost[i]);
            totalt=totalt+(gas[i]-cost[i]);
            if(totalt<0){
                totalt=0;
                s=i+1;
            }
        }
        if(total<0){
            return -1;
        }

        return s;
    }
}