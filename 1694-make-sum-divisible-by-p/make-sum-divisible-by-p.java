class Solution {
    public int minSubarray(int[] nums, int p) {
        long prefixSum=0;
        for(int i:nums){
            prefixSum+=i;
        }
        int target=(int)(prefixSum%p);
        if(target==0) return 0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        prefixSum=0;
        int ans=nums.length;    
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int mod=(int)(prefixSum%p);
            int tmod=(mod-target+p)%p;
            if(hm.containsKey(tmod)){
                int l=hm.get(tmod);
                ans=Math.min(ans,i-l);
            }
            hm.put(mod,i);
        }
        return ans==nums.length?-1:ans;
    }
}