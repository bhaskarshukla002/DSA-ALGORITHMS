class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,target,new ArrayList<>(),ans,candidates);
        return ans; 
        
    }
    void helper(int start,int t,List<Integer> curr,List<List<Integer>> ans,int[] nums){
        if(t==0){
            // if(currSum==t){
                ans.add(new ArrayList<>(curr));
            // }
            return;
        }
        for(int i=start;i<nums.length;i++){
            // if(nums[i]>t) return;
            // currSum=currSum+nums[i];
            if(nums[i]>t) break;
            if (i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            helper(i+1,t-nums[i],curr,ans,nums);
            // currSum=currSum-nums[i];
            curr.remove(curr.size()-1);
        }
    }
}