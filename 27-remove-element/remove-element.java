class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int i=0;
        int t=0;
        while(t<n){
            if(nums[t]!=val){
                nums[i]=nums[t];
                i++;
            }
            t++;
        }
        return i;
        
    }
}