class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> num=new ArrayList<Integer>();
        int len=nums.length;
        for(int i=0;i<nums.length;i++){
            num.add(nums[i]);
        }
        List<List<Integer>> ans=new ArrayList<>();
        permute(num,ans,0,len);
        return ans;
    }
    public void permute(List<Integer> nums,List<List<Integer>> ans,int l,int h){
        if(l==h)
        ans.add(new ArrayList<>(nums));
        else
        for(int i=l;i<h;i++){
            swap(nums,i,l);
            permute(nums,ans,l+1,h);
            swap(nums,i,l);
        }
    }
    void swap(List<Integer> nums,int i,int j){
        int temp=nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }
}