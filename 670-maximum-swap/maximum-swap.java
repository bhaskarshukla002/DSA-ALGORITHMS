class Solution {
    public int maximumSwap(int num) {
        int max=0;
        String s=""+num;
        int res=num;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                char[] a=s.toCharArray();
                char t=a[i];
                a[i]=a[j];
                a[j]=t;
                int newNum=Integer.parseInt(new String(a));
                res=Math.max(res,newNum);
            }

        }
        return res;
        
    }
}