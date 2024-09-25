class Solution {
    TrieNode root=new TrieNode();
    void insert(String word){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(node.next[c-'a']==null){
                node.next[c-'a']=new TrieNode();
            }
            node.next[c-'a'].cnt++;
            node=node.next[c-'a'];
        }
    }
    int count(String word){
        TrieNode node=root;
        int sum=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            // if(node.next[c-'a']==null){
            //     node.next[c-'a']==new TrieNode();
            // }
            sum+=node.next[c-'a'].cnt;
            node=node.next[c-'a'];
        }
        return sum;
    }


    public int[] sumPrefixScores(String[] words) {
        int[] res=new int[words.length];
        int i=0;
        for(String s:words){
            insert(s);
        }
        while(i<words.length){
            res[i]=count(words[i++]);
        }
        return res;
    }
}
class TrieNode{
    TrieNode[] next=new TrieNode[26];
    int cnt=0;
}