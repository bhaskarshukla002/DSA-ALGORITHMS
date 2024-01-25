class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-1-1;
        while(i>=0){
            if(nums[i]<nums[i+1]){
                break;
            }
            i--;
        }
        if(i==-1){
            //reverse and return
            reverse(nums,0,n-1);
            return;
        }
        int j=n-1;
        while(j>0){
            if(nums[j]>nums[i]){
                swap(nums,i,j);
                reverse(nums,i+1,n-1);
                return;
            }
            j--;
        }

    }
    void reverse(int nums[],int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;   
        }
    }
    void swap(int nums[],int i,int j){
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
    }
}