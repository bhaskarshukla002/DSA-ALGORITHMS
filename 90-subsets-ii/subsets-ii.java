class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,new ArrayList<>(),nums,0,false);
        return ans;
    }
    void helper(List<List<Integer>> ans,List<Integer> curr,int nums[],int k,boolean flag){
        if(k==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
            helper(ans,curr,nums,k+1,false);
            if(k>=1&&nums[k]==nums[k-1]&&!flag) return;
            curr.add(nums[k]);
            helper(ans,curr,nums,k+1,true);
            curr.remove(curr.size()-1);
    }
}