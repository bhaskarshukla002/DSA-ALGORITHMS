class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1=Integer.MIN_VALUE;
        int v1=0;
        int n2=Integer.MIN_VALUE;
        int v2=0;
        for(int i:nums){
            if(v1==0&&n2!=i){
            n1=i;
            v1=1;}
            else if(v2==0&&n1!=i){
            n2=i;
            v2=1;}
            else if(n1==i)
            v1++;
            else if(n2==i)
            v2++;
            else
            {v1--;
            v2--;
            }
        }
        v1=0;
        v2=0;
        for(int i:nums){
            if(i==n1)
            v1++;
            if(i==n2)
            v2++;
        }
        List<Integer> ans= new ArrayList<>();
        if(v1>nums.length/3)
        ans.add(n1);
        
        if(v2>nums.length/3)
        ans.add(n2);
        return ans;
    }
}