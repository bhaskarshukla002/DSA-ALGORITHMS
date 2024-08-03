class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i:target){
            if(hm.containsKey(i)){
                if(hm.get(i)==0)
                    return false; 
            }else{
                return false;
            }
            hm.put(i,hm.get(i)-1);
        }
        return true;
    }
}