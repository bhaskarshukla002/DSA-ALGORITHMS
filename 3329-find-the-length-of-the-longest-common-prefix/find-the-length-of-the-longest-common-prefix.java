class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            String s=""+arr1[i];
            for(int j=1;j<=s.length();j++){
                hs.add(s.substring(0,j));
            }
        }
        int ans=0;
        for(int i=0;i<arr2.length;i++){
            String s=""+arr2[i];
            for(int j=1;j<=s.length();j++){
                String sub=s.substring(0,j);
                if(hs.contains(sub)){
                    ans=Math.max(ans,sub.length());
                }
            }
        }
        return ans;
    
        
    }
}