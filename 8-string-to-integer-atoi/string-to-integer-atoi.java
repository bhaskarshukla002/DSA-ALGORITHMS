class Solution {
    public int myAtoi(String s) {
        int sign=1;
        // String num="";
        int i=0;
        int res=0;
        int n=s.length();
        while(i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        if(i<s.length()&&s.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(i<s.length()&&s.charAt(i)=='+'){
            i++;
        }
        while(i<s.length()&&s.charAt(i)>=48&&s.charAt(i)<=57){
            int digit = s.charAt(i) - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    if(sign==1)
                    return Integer.MAX_VALUE;
                    else
                    return Integer.MIN_VALUE;
                }
                res=res*10+digit;
                i++;
        }
        return (res*sign);
    }
}