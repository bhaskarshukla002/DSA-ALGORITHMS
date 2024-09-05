class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        int m=rolls.length;
        for(int i=0;i<m;i++){
            sum+=rolls[i];
        }
        int nSum=mean*(m+n)-sum;

        if(nSum>6*n||nSum<n){
            return new int[0];
        }

        int val=nSum/n;
        int mod=nSum%n;

        int[] nRolls=new int[n];
        Arrays.fill(nRolls,val);
        for(int i=0;i<mod;i++){
            nRolls[i]++;
        }
        return nRolls;
        
        
    }
}