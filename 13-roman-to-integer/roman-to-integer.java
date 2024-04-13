class Solution {
    public int romanToInt(String s) {
        int ans=0;
        int n=s.length()-1;
        int val[]=new int[26];
        val['I'-'A']=1;
        val['V'-'A']=5;
        val['X'-'A']=10;
        val['L'-'A']=50;
        val['C'-'A']=100;
        val['D'-'A']=500;
        val['M'-'A']=1000;
        int curr;
        int last=0;
        while(n>=0){
            char c=s.charAt(n);
            if(val[c-'A']<ans&&last!=c){
                ans=ans-val[c-'A'];
            }else{
                ans=ans+val[c-'A'];
            }
            last=c;
            n--;
        }
        return ans;
    }
}