class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] min=new int[timePoints.size()];
        int idx=0;
        for(String time:timePoints){
            min[idx]=Integer.parseInt(time.substring(0,2))*60+Integer.parseInt(time.substring(3));
            idx++;
        }
        Arrays.sort(min);
        int res=Integer.MAX_VALUE;
        for(int i=0;i<min.length-1;i++){
            res=Math.min(res,(min[i+1]-min[i]));
        }
        return Math.min(res,24*60-min[min.length-1]+min[0]);
        
    }
}