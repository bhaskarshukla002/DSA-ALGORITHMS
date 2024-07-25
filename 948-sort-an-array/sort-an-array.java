class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0,nums.length-1,nums);
        return nums;
    }
    void mergeSort(int l,int h,int[] nums)
    {
        if(l>=h)
        return;
        int m=l+(h-l)/2;
        mergeSort(l,m,nums);
        mergeSort(m+1,h,nums);
        merge(l,m,h,nums);
    }
    void merge(int l,int m,int h,int[] nums){
        int n1=m-l+1;
        int n2=h-m;
        int[] left=new int[n1];
        int[] right=new int[n2];

        for(int i=0;i<n1;i++)
            left[i]=nums[l+i];
        for(int i=0;i<n2;i++)
            right[i]=nums[m+i+1];
        int i=0,j=0,k=l;

        while(i<n1&&j<n2){
            if(left[i]<=right[j])
            nums[k++]=left[i++];
            else
            nums[k++]=right[j++];
        }

        while(i<n1){
            nums[k++]=left[i++];
        }
        while(j<n2){
            nums[k++]=right[j++];
        }
    }
}