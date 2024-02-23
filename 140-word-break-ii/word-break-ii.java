class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans=new ArrayList<>();
		helper(s,wordDict,ans,0,"");
		return ans;
    }
    static void helper(String s, List<String> dictionary,List<String> ans,int start,String curr){
		if(start==s.length()){
			ans.add(curr.substring(0,curr.length()-1));
			return;
		}
		for(int i=start;i<s.length();i++)
		{
			String temp=s.substring(start,i+1);
			if(dictionary.contains(temp)){
				// s=s.substring(0,i)+" "+s.substring(i,s.length());
				helper(s,dictionary,ans,i+1,curr+temp+" ");
				// s=s.substring(0,i)+""+s.substring(i+2,s.length());
			}
		}
	}
}