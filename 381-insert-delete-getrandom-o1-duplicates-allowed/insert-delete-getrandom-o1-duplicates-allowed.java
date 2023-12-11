class RandomizedCollection {

    private  HashMap<Integer,Set<Integer>> hm;
    private  ArrayList<Integer> nums;

    public RandomizedCollection() {
        hm=new HashMap<>();
        nums=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        // boolean contains=;
        if(!hm.containsKey(val))
        hm.put(val,new HashSet<>());
        hm.get(val).add(nums.size());
        nums.add(val);
        return hm.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)){
            return false;
        }
        int ind1=hm.get(val).iterator().next();
        hm.get(val).remove(ind1);
        if(ind1<nums.size()-1){
        int ind2=nums.get(nums.size()-1);
        nums.set(ind1,ind2);
        hm.get(ind2).remove(nums.size()-1);
        hm.get(ind2).add(ind1);
        }
        nums.remove(nums.size()-1);
        if(hm.get(val).isEmpty()) hm.remove(val);
        return true;
        
    }
    
    public int getRandom() {
        // int random=;
        return nums.get((int) (Math.random()*nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */