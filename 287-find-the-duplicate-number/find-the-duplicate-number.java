class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>(); 
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(hs.contains(nums[index])){
                return nums[index];
            }
            hs.add(nums[index]);
            index=nums[index];
        }
        return -1;
    }
}