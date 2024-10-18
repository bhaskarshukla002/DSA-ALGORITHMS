class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxor=0;
        for(int i:nums){
            maxor=maxor|i;
        }
        return backtrack(0,0,maxor,nums);
    }

    public int backtrack(int i,int curror,int maxor,int nums[]){
        if(i==nums.length){
            return (curror==maxor)?1:0;
        }
        int nextcount=backtrack(i+1,curror,maxor,nums);
        int withcount=backtrack(i+1,curror|nums[i],maxor,nums);
        return nextcount+withcount;
    }
}