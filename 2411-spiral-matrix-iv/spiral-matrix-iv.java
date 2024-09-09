/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int move[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(res[i],-1);
        }
        int row=0;
        int col=0;
        int dir=0;
        while(head!=null){
            res[row][col]=head.val;
            int nrow=row+move[dir][0];
            int ncol=col+move[dir][1];
            if(Math.min(nrow,ncol)<0||nrow>=m||ncol>=n||res[nrow][ncol]!=-1)
            dir=(dir+1)%4;
            row=row+move[dir][0];
            col=col+move[dir][1];
            head=head.next;
        }
        return res;
    }
}