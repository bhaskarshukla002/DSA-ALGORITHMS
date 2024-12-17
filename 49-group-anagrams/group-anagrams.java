class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>(); 
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        
        for(String s:strs){
            char temp[] = s.toCharArray();
            Arrays.sort(temp);
            String sorted=new String(temp);
            if(hm.containsKey(sorted)){
                ans.get(hm.get(sorted)).add(s);
            }else{
                ans.add(new ArrayList<>());
                ans.get(ans.size()-1).add(s);
                hm.put(sorted,ans.size()-1);
            }
        }
        return ans;
        
    }
}