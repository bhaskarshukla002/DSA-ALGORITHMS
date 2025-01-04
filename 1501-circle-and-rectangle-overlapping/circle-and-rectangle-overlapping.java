class Solution {
    public boolean checkOverlap(int r, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x=Math.max(x1,Math.min(x2,xCenter));
        int y=Math.max(y1,Math.min(y2,yCenter));

        int dist=(x-xCenter)*(x-xCenter) + (y - yCenter) * (y - yCenter);
        return dist<= r*r;

        
    }
}