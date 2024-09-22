class Solution {
    public int findKthNumber(int n, int k) {
        int curr=1;
        k-=1;
        while(k>0){
            int ncount=count(curr,curr+1,n);
            if(ncount<=k){
                curr+=1;
                k-=ncount;
            }else{
                curr *=10;
                k-=1;
            }
        }

        return curr;
    }

    int count(long a,long b, int n){
        int steps=0;
        while(a<=n){
            steps+=Math.min(n+1,b)-a;
            a*=10;
            b*=10;
        }
        return steps;
    }
}