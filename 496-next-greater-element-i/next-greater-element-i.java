class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] ans=new int[n1];
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<n1;i++){
            hs.put(nums1[i],i);
        }
        int nge=-1;
        Stack<Integer> st=new Stack<>();
        for(int i=n2-1;i>=0;i--){
            while(!st.empty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if (!st.empty()) nge=st.peek();
            else nge=-1;
            if(hs.containsKey(nums2[i])){
                ans[hs.get(nums2[i])]=nge;
            }
            st.push(nums2[i]);
        }
        return ans;
    }
}