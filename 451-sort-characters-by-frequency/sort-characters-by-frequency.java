class Solution {
    public String frequencySort(String s) {
        // HashMap<Character,Integer> hm=new HashMap<>();
        
        int[][] temp=new int[128][2];
        for(int i=0;i<128;i++){
            temp[i][0]=i;
            temp[i][1]=0;
        }
        for(int i=0;i<s.length();i++){
            temp[s.charAt(i)][1]++;
        }
        Arrays.sort(temp,(a,b)->(b[1]-a[1]));
        String ans="";
        for(int i=0;i<128;i++){
            int m=temp[i][1];
            int st=temp[i][0];
            for(int j=0;j<m;j++)
            ans=ans.concat(String.valueOf((char)st));
        }
        return ans;
        // for(Map.Entry<String, Integer> entry : hm.entrySet()){
        //     hm.
        // }
    }
}