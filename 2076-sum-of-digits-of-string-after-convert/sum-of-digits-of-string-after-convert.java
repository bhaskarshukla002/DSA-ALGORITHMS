class Solution {
    public int getLucky(String s, int k) {
        int res=0;
        for(int i=0;i<s.length();i++){
            int val=s.charAt(i)-'a'+1;
            while (val > 0) {
                res += val % 10;
                val/= 10;
            }
        }
        
        // int res= Integer.parseInt(ss);
        
        while(k>1){
            int sum=0;
            while(res>0){
                sum=sum+res%10;
                res/=10;
            }
            res=sum;
            k--;
        }
        return res;
    }
}