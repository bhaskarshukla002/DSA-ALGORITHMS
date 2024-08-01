class Solution {
    public int countSeniors(String[] details) {
        int ans=0;
        for(String s:details){
            char[] stringArr=s.toCharArray();
            int age=(stringArr[11]-'0')*10+(stringArr[12]-'0');
            if(age>60)
                ans++;
        }
        return ans;
        
    }
}