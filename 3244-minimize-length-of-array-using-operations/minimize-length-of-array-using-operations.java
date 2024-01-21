class Solution {
    public int minimumArrayLength(int[] nums) {
        int n=nums[0],count=0;
        for(int i:nums)
            n=Math.min(n,i);
        for(int i:nums){
            if(i==n)
            count++;
            if(i%n>0)
            return 1;
        }
        return (count+1)/2;
        
        
        
    }
}