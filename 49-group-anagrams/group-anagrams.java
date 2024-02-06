class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0)return new ArrayList<>();
        int n=strs.length;
        // List<List<String>> ans=new ArrayList<>();
        char c[];
        HashMap<String,List<String>> ans=new HashMap<>();
        for(int i=0;i<n;i++){
            String st=strs[i];
            c=new char[26];
            for(char ca:st.toCharArray()){
                c[ca-'a']++;
            }
            String str=String.valueOf(c);
            if(!ans.containsKey(str)){
                // ans.get(hs.get(str)).add(st);
                ans.put(str,new ArrayList<>());
            }
            // List<String> temp=new ArrayList<>();
            // temp.add(st);
                ans.get(str).add(st);
            // }
        }
        return new ArrayList<>(ans.values());
        
    }
}