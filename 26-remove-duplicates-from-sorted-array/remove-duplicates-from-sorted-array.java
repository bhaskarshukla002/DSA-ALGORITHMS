class Solution {
    public int removeDuplicates(int[] nums) {
        int ind=0,i=1;
        while(i<nums.length){
            if(nums[i]!=nums[ind]){
                ind++;
                nums[ind]=nums[i];
            }
                i++;
        }
        return ind+1;
        
    }
}