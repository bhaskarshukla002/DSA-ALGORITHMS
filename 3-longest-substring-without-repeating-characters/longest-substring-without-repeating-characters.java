class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        if(s.length()==0){
            return 0;
        }
        int l=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                while(l<i && hs.contains(s.charAt(i)))
                    hs.remove(s.charAt(l++));
            }
            hs.add(s.charAt(i));
            ans=Math.max(i-l+1,ans);
        }
        // ans=Math.max(i-l+1,ans);
        return ans;
    }
}