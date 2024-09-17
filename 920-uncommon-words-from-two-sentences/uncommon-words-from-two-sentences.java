class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        HashMap<String,Integer> hm=new HashMap<>();
        for(String s:s1.split(" ")){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        for(String s:s2.split(" ")){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        List<String> list=new ArrayList<>();
        for(Map.Entry<String,Integer> entry : hm.entrySet()){
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}