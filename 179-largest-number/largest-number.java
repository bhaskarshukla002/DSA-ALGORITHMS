class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String[] ss=new String[n];
        for(int i=0;i<n;i++){
            ss[i]=String.valueOf(nums[i]);
            // ss=ss+s;
        }
        // char []a=ss.toCharArray();
        Arrays.sort(ss,(a,b)->(b+a).compareTo(a+b));

        return ss[0].equals("0")?"0":String.join("",ss);
        
    }
}