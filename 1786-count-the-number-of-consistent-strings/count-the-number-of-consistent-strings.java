class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        int[] ch=new int[26];
        for(int i=0;i<allowed.length();i++){
            ch[allowed.charAt(i)-'a']=1;
        }
        int res=0;

        for(int i=0;i<words.length;i++){
            int f=1;
            for(int j=0;j<words[i].length();j++){
                if(ch[words[i].charAt(j)-'a']==0){
                    f=0;
                    break;
                }
            }
            res=res+f;
        }
        return res;
    }
}