class Solution {
    public int minOperations(String[] logs) {
        int dis=0;
        for(String log:logs){
            if(log.charAt(0)=='.'){
                if(log.charAt(1)=='.'){
                    if(dis>0)
                    dis--;
                }else{
                    
                }
            }else{
                dis++;
            }
        }
        return dis;       
    }
}