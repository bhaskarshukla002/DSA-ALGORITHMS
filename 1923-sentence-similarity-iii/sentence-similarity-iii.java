class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        
        
        String a1[]=s1.split(" ");
        String a2[]=s2.split(" ");
        if(a1.length>a2.length){
            return areSentencesSimilar(s2,s1);
        }
        int start=0;
        int l1=a1.length;
        int l2=a2.length;
        int end1=l1-1;
        int end2=l2-1;
        while(start<l1&&a1[start].equals(a2[start])){
            start++;
        }
        while(end1>=0&&a1[end1].equals(a2[end2])){
            end1--;
            end2--;
        }
        return end1<start;

        
    }
}