class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> listSet=new HashSet<>();
        for(int i=0;i<wordList.size();i++) {
            listSet.add(wordList.get(i));
        }
        Queue<Pair<Integer,String>> q=new LinkedList<>();
        // listSet.remove(beginWord);
        q.add(new Pair<>(1,beginWord));
        while(!q.isEmpty()){
            Pair<Integer,String> p=q.poll();
            int path=p.getKey();
            String s=p.getValue();
            if(s.equals(endWord)){
                return path;
            }
            for(int k=0;k<s.length();k++){
            for(char c='a';c<='z';c++){
                char repCharArray[]=s.toCharArray();
                repCharArray[k]=c;
                String repWord=new String(repCharArray);
                if(listSet.contains(repWord)){ 
                    listSet.remove(repWord);
                    q.add(new Pair<>(path+1,repWord));
                }
            }
            }
        }
        return 0;
    }
}