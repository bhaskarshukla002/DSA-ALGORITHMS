class Solution {
    public void nextPermutation(int[] nums) {
        int n =nums.length;
        int i=-1;
        for(int i1=n-2;i1>=0;i1--){
            if(nums[i1]<nums[i1+1]){
                i=i1;
                break;
            }
        }
        if(i==-1){
            reverse(nums,0,n-1);
            return;
        }
        for(int j=n-1;j>=0;j--){
            if(nums[j]>nums[i]){
                swap(nums,i,j);
                reverse(nums,i+1,n-1);
                return;
            }
        }
    }
    void reverse(int []nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    void swap(int []nums,int i,int j){
        nums[i]=nums[i]+nums[j];
        nums[j]=nums[i]-nums[j];
        nums[i]=nums[i]-nums[j];
    }
}