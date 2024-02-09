class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        helper(ans,new ArrayList<>(),0,s);
        return ans;

    }
    void helper(List<List<String>> ans,List<String> curr,int start,String s){
        if(start==s.length())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
            curr.add(s.substring(start,i+1));
            helper(ans,curr,i+1,s);
            curr.remove(curr.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}