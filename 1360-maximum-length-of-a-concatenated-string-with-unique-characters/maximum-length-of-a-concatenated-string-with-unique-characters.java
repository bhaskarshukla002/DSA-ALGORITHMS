class Solution {
    public int maxLength(List<String> arr) {
        return backtrack("",arr,0);
    }

    int backtrack(String s,List<String> arr,int idx){
        HashSet<Character> set = new HashSet<>();
        for (int j = 0; j < s.length(); j++) {
            set.add(s.charAt(j));
        }
        if(set.size()<s.length())
            return 0;
        int ans=s.length();
        if(idx>=arr.size()){
            return ans;
        }
        int take=backtrack(s+arr.get(idx),arr,idx+1);
        int nottake=backtrack(s,arr,idx+1);
        return Math.max(take,nottake);
    }

    boolean isUnique(String s){
        HashSet<Character> hs=new HashSet<>();
            int n=s.length();
            for(int i=0;i<n;i++){
                hs.add(s.charAt(i));
            }
            if(hs.size()<n)
            return false;
            return true;
    }
}