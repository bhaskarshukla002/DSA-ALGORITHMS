class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,0,target,0,new ArrayList<>(),ans);
        return ans;
    }
    void helper(int[] nums,int start,int t,int currSum,List<Integer> curr,List<List<Integer>> ans){
        if(currSum>=t){
            if(currSum==t){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i=start;i<nums.length;i++){
            currSum=currSum+nums[i];
            curr.add(nums[i]);
            helper(nums,i,t,currSum,curr,ans);
            currSum-=nums[i];
            curr.remove(curr.size()-1);
            // helper(nums,i-1,t,currSum,curr,ans);
        }
    }
}