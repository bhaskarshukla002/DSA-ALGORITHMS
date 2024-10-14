class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->(b-a));
        for(int i:nums){
            pq.add(i);
        }
        long score=0;
        while(k-->0){
            int t=pq.poll();
            score+=t;
            pq.add((int)Math.ceil(t/3.0));
        }
        return score;
        
    }
}