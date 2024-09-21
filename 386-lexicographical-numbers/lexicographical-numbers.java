class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(i,n,res);
            
        }
        return res;
        
    }

    void dfs(int i,int n,List<Integer> res){
        if(i>n)
        return;
        res.add(i);
        for(int j=0;j<=9;j++){
            int k=i*10+j;
            if(i<=n){
                dfs(k,n,res);
            }else{
                break;
            }
        }
    }
}