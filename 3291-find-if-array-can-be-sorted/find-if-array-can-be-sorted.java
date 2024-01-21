class Solution {
    public boolean canSortArray(int[] nums) {
        // boolean ans=true;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(nums[j]>nums[j+1]){
                    if(countSetBit(nums[j])==countSetBit(nums[j+1])){
                        int t=nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=t;
                    }
                }
            }
        }
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }           
        return true;
    }
    int countSetBit(int n){
        int count = 0;
        while (n != 0) {
            if((n & 1) == 1){
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}