class Solution {
    public long dividePlayers(int[] arr) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int total=0;
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
            total+=i;
        }
        int n=arr.length;
        int target=total/(n/2);
        if (total % (n / 2) != 0) {
            return -1;
        }
        long chem=0;
        for(int skill : hm.keySet()){
            int freq=hm.get(skill);
            int skill2=target-skill;
            if(!hm.containsKey(skill2)||freq!=hm.get(skill2)){
                return -1;
            }
            chem+=(long)skill*(long)(skill2)*(long)(freq);
            
        }
        return chem/2;
        
    }
}