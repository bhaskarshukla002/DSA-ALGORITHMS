class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> hs=new HashMap<>();
        for(int i:nums){
            hs.put(i,hs.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(Map.Entry<Integer,Integer> entry : hs.entrySet())
        pq.add(new int[]{entry.getKey(),entry.getValue()});
        int[] ans=new int[k];
        int i=0;
        while(i<k){
            int[] ar=pq.poll();
            ans[i++]=ar[0];
        }
        return ans;
    }
}