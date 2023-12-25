class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
        int[] t=intervals[0];
        for(int i=0;i<intervals.length;i++)
        {
            if(intervals[i][0]<=t[1]){
                t[1]=Math.max(intervals[i][1],t[1]);
            }else{
                ans.add(t);
                t=intervals[i];
            }
        }
        ans.add(t);
        return ans.toArray(new int[0][]);
    }
}