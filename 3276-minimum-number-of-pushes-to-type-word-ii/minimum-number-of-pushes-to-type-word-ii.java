class Solution {
    public int minimumPushes(String word) {
        // HashMap<Character,Integer> keyMap=new HashMap<>();
        int ans=0;
        int len=word.length();
        int[] val=new int[26];
        for(int i=0;i<len;i++){
            int ind=word.charAt(i)-'a';
            val[ind]=val[ind]+1;
        }
        // Set<Integer> keys = keyMap.values();

        // Integer[] array = keyMap.values().toArray(new Integer[0]);
// and if you want int instead of Integer, then iterate over each element

        // int[] array = new int[keys.size()];
        // int index = 0;
        // for(Integer element : keys) array[index++] = element.intValue();
        Arrays.sort(val);
        for(int i=0;i<26;i++){
            int v=0;
            if(val[i]>0){
            if(i<=1){
                v=4*val[i];
            }
            if(i>1&&i<=9){
                v=3*val[i];
            }
            if(i>9&&i<=17){
                v=2*val[i];
            }if(i>17&&i<=25){
                v=1*val[i];
            }
            }
            ans=ans+v;
        }
        return ans;
        
    }
}