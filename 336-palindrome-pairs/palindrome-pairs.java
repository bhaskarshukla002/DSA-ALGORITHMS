class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashSet<List<Integer>> res=new HashSet<>();
        HashMap<String,Integer> hm=new HashMap<>();
        int n=words.length;
        for(int i=0;i<n;i++){
            hm.put(words[i],i);
        }  
        //empty casea
        if(hm.containsKey("")){
            Integer index=hm.get("");
            for(int i=0;i<n;i++){
                if(index!=i&&isPalindrome(words[i])){
                    res.add(Arrays.asList(index,i));
                    res.add(Arrays.asList(i,index));
                }
            }
        }
        //reverse case
        for(int i=0;i<n;i++){
            String rev=new StringBuilder(words[i]).reverse().toString();
            Integer index=hm.get(rev);
            if(index!=null&&index!=i){
                res.add(Arrays.asList(i,index));
                res.add(Arrays.asList(index,i));
            }
        } 
        //split case
        for(int i=0;i<n;i++){
            for(int j=1;j<words[i].length();j++){
                String left=words[i].substring(0,j);
                String right=words[i].substring(j);
                if(isPalindrome(left)){
                    String rev=new StringBuilder(right).reverse().toString();
                    if(hm.containsKey(rev)){
                        res.add(Arrays.asList(hm.get(rev),i));
                        // ans.add(Arrays.asList(i,index));
                    }
                }
                if(isPalindrome(right)){
                    String rev=new StringBuilder(left).reverse().toString();
                    // int index=;
                    if(hm.containsKey(rev)){
                        res.add(Arrays.asList(i,hm.get(rev)));
                        // ans.add(Arrays.asList(i,index));
                    }
                }
            }
        }
            return new ArrayList<>(res);
    }

    boolean isPalindrome(String s){
        int l=0,h=s.length()-1;
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}