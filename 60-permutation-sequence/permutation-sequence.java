class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> ans=new ArrayList<>();
        String s="";
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            ans.add(i);
            // s=s+i;
        }
        ans.add(n);
        k=k-1;
        while(true){
            s=s+ans.get(k/fact);
            ans.remove(k/fact);
            if(s.length()==n){
                break;
            }
            k=k%fact;
            fact=fact/ans.size();
        }
        
        return s;
    }
    // void helper(char[] arr,int start,List<String> ans){
    //     if(start==arr.length){
    //         ans.add(new String(arr));
    //         return;
    //     }
    //     for(int i=start;i<arr.length;i++){
    //         swap(arr,start,i);
    //         helper(arr,start+1,ans);
    //         swap(arr,start,i);
    //     }
    // }
    // void swap(char[] arr,int i,int j){
    //     char temp=arr[i];
    //     arr[i]=arr[j];
    //     arr[j]=temp;
    // }
}