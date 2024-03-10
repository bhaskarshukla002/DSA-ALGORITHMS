class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window=new ArrayDeque<>();
        // int max=Integer.MIN_VALUE;
        int n=nums.length;
        int[] ans=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(!window.isEmpty()&&window.peekFirst()==i-k)
                window.pollFirst();
            while(!window.isEmpty()&&nums[i]>nums[window.peekLast()]){
                window.pollLast();
            }
            window.offerLast(i);
            if(i>=k-1)
            ans[i-k+1]=nums[window.peekFirst()];
        }
        return ans;
    }
}