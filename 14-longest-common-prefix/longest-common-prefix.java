class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int idx=0;
        while(idx<strs[0].length()&&idx<strs[strs.length-1].length()){
            if(strs[0].charAt(idx)==strs[strs.length-1].charAt(idx))
            idx++;
            else
            break;
        }

        return strs[0].substring(0,idx);
        
    }
}