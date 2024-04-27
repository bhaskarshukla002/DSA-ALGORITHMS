class Solution {
    public int repeatedStringMatch(String a, String b) {

        // int minRepeat=Math.ceil(b.length()/a.length());
        int ans=0;
        String r="";
        while(r.length()<b.length()){
            r=r+a;
            ans++;
        }
        if(r.indexOf(b)!=-1){
            return ans;
        }
        r=r+a;
        ans++;
        if(r.indexOf(b)!=-1){
            return ans;
        }
        return -1;
        
    }
}