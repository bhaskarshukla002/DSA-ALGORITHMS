class Solution {
    public String largestNumber(int[] nums) {
        String[] nos=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            nos[i]=Integer.toString(nums[i]);
        }
        Arrays.sort(nos,(a,b)->(b+a).compareTo(a+b));
        String res="";
        for(String s:nos){
            res=res+s;
        }
        if(nos[0].equals("0")){
            return "0";
        }
        return res;
        
    }
}