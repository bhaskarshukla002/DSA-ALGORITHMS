//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<int[]> q=new LinkedList<>();
        int count[]=new int[100000];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[start]=0;
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int node=q.peek()[0];
            int currCount=q.peek()[1];
            q.poll();
            if(node==end)
            return currCount;
            for(int i:arr){
                int v=(i*node)%100000;
                if(count[v]>currCount+1){
                    count[v]=currCount+1;
                    q.add(new int[]{v,count[v]});
                }
            }
        }
        return -1;
    }
}
