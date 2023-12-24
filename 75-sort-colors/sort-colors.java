class Solution {
    public void sortColors(int[] nums) {

        int l=0,h=nums.length-1, i=0;
        int temp;
        while(i<=h){
            if(nums[i]==0){
                temp=nums[l];
                nums[l]=0;
                nums[i]=temp;
                l++;i++;
            }else if(nums[i]==1){
                i++;
            }else if(nums[i]==2){
                temp=nums[h];
                nums[h]=2;
                nums[i]=temp;
                h--;
            }
            
        }
    }
}