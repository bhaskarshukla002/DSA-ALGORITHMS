class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        // List<Integer> num=new ArrayList<>();
        // for(int i:nums)
        // num.add(i);
        permute(ans,nums,new ArrayList<>(),new boolean[nums.length]);
        return ans;
    }
    void permute(List<List<Integer>> ans,int[] nums,List<Integer> curr,boolean[] used){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;        
        }else
        for(int i=0;i<nums.length;i++){
            if(used[i])
            continue;
            if( i>0 && nums[i-1]==nums[i] && !used[i-1] )
            continue;
            curr.add(nums[i]);
            used[i]=true;
            permute(ans,nums,curr,used);
            used[i]=false;
            curr.remove(curr.size()-1);
        }
        
    }
    // void swap(List<Integer> nums,int i,int j){
    //     int temp=nums.get(i);
    //     nums.set(i,nums.get(j));
    //     nums.set(j,temp);
    // }
}