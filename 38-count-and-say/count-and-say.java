class Solution {
    public String countAndSay(int n) {
        // int i=0;
        List<Pair<Character,Integer>> arr;
        String ans="1";
        for(int j=1;j<n;j++){
            arr=countCreate(ans);
            ans=stringCreate(arr);
        }
        return ans;
        
    }
    public List<Pair<Character,Integer>> countCreate(String n){
        List<Pair<Character,Integer>> arr=new ArrayList<>();
        int freq=0;
        int len=n.length();
        int i=0;
        int val=0;
        while(i<len){
            int c=n.charAt(i);
            if(c==n.charAt(val)){
                freq++;
                // n=n/10;
            }else{
                arr.add(new Pair(n.charAt(val),freq));
                freq=1;
                val=i;
            }
            i++;
        }
        arr.add(new Pair(n.charAt(val),freq));
        return arr;
        
    }
    public String stringCreate(List<Pair<Character,Integer>> arr){
        int len=arr.size();
        String s="";
        for(int i=0;i<len;i++){
            s=s+(char)(48+arr.get(i).getValue())+arr.get(i).getKey();
        }
        return s;
    }
}