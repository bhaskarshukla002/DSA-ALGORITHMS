class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26];
        int l1=s1.length();
        int l2=s2.length();
        for(char c:s1.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0;i<l2-l1+1;i++){
            int[] temp=freq.clone(); 
            for(int j=i;j<i+l1;j++){
                if(temp[s2.charAt(j)-'a']==0){
                    break;
                }else if(temp[s2.charAt(j)-'a']>0){
                    temp[s2.charAt(j)-'a']--;
                    if(j+1==i+l1)
                    return true;
                }
            }
        }
        return false;
        
    }
}