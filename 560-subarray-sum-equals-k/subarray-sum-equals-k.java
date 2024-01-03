class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int curr=0;
        int ans=0;
        hs.put(0,1);
        for(int i=0;i<nums.length;i++){
            curr=curr+nums[i];
            if(hs.containsKey(curr-k)){
                ans+=hs.get(curr-k);
            }
            hs.put(curr,hs.getOrDefault(curr,0)+1);
        }
        return ans;
    }
}