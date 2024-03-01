class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->b-a);
        int n=nums.length;
        for(int i:nums)
        pq.add(i);
        while(k-->1){
            pq.remove();
        }
        return pq.peek();
    }

    //sol-1
    // public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums,(a,b)=>(b-a));
        // return nums[k];
    // }


}