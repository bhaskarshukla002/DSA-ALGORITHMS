class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet<Character> hs=new HashSet<>();
        int[] charArr=new int[128];
        Arrays.fill(charArr,-1);
        int l=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(l<=charArr[s.charAt(i)]){
                l=charArr[s.charAt(i)]+1;
                // charArr[s.charAt(i)]=i;
            }
            charArr[s.charAt(i)]=i;
            ans=Math.max(i-l+1,ans);
        }
        // ans=Math.max(i-l+1,ans);
        return ans;
    }
}