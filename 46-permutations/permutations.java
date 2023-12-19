class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> num=new ArrayList<Integer>();
        // int len=nums.length;
        for(int i=0;i<nums.length;i++){
            num.add(nums[i]);
        }
        List<List<Integer>> ans=new ArrayList<>();
        permute(num,ans,0);
        return ans;
    }
    public void permute(List<Integer> nums,List<List<Integer>> ans,int l){
        if(l==nums.size()-1){
        ans.add(new ArrayList<>(nums));
        return;}
        else
        for(int i=l;i<nums.size();i++){
            swap(nums,i,l);
            permute(nums,ans,l+1);
            swap(nums,i,l);
        }
    }
    void swap(List<Integer> nums,int i,int j){
        int temp=nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }
}