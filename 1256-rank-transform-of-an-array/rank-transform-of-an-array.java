class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer,List<Integer>> set=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            if(!set.containsKey(arr[i]))
                set.put(arr[i],new ArrayList<>());
            set.get(arr[i]).add(i);
        }
        int rank=1;
        for(int num : set.keySet()){
            for(int ind:set.get(num)){
                arr[ind]=rank;
            }
            rank++;
        }
        return arr;
    }
}