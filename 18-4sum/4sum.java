class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length-1;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int h=n;
                int l=j+1;
                while(l<h){
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[l];
                    sum+=nums[h];
                    if(sum==target){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[h]);
                        ans.add(temp);
                        l++;h--;
                        while (l < h && nums[l] == nums[l - 1]) l++;
                        while (l < h && nums[h] == nums[h + 1]) h--;
                    }else if(sum<target)
                    l++;
                    else
                    h--;
                }
            }
        }
        return ans;
        
    }
}