class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int[][] ans=new int[n/3][3];
        Arrays.sort(nums);
        int j=0;
        for(int i=0;i<n;i=i+3){
            if(nums[i+2]-nums[i]<=k){
                ans[j][0]=nums[i];
                ans[j][1]=nums[i+1];
                ans[j++][2]=nums[i+2];
            }else{
                return new int[0][0];
            }
        }
        return ans;
    }
}