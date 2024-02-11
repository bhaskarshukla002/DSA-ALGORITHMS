class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        // Arrays.sort(nums);
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        helper(0,ans,arr);
        return ans;
    }
    void helper(int start,List<List<Integer>> ans,List<Integer> nums){
        if(start==nums.size()-1){
            // List<Integer> temp=new ArrayList<>(List.of(nums));
            ans.add(new ArrayList<>(nums));
            return;
            }
        else
        for(int i=start;i<nums.size();i++){
            // curr.add(nums[i]);
            swap(nums,start,i);
            helper(start+1,ans,nums);
            // curr.remove(curr.size()-1);
            swap(nums,start,i);
        }
    }
    void swap(List<Integer> arr,int i,int j){
        int temp=arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    } 
}