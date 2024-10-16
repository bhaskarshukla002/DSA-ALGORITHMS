class Solution {
    public String longestDiverseString(int a, int b, int c) {
        String res="";
        int curra=0,currb=0,currc=0;
        int t=a+b+c;
        while(t-->0){
            if((a>=b&&a>=c&&curra!=2)||(a>0&&(currb==2||currc==2))){
                res+='a';
                curra++;
                currb=0;
                currc=0;
                a--;
            }else if((b>=a&&b>=c&&currb!=2)||(b>0&&(curra==2||currc==2))){
                res+='b';
                currb++;
                curra=0;
                currc=0;
                b--;
            }else if((c>=b&&c>=a&&currc!=2)||(c>0&&(currb==2||curra==2))){
                res+='c';
                currc++;
                currb=0;
                curra=0;
                c--;
            }
        }
        return res;
    }
    
}