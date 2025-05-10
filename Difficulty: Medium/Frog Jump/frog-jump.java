//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// User function Template for Java

class Solution {
    int minCost(int[] height) {
        // code here
        int []dp=new int[height.length+1];
        for(int i=0;i<=height.length;i++){
            dp[i]=-1;
        }
        return recur(height,height.length,dp);
    }

    int recur(int h[],int n,int dp[]){
        if(n==1)
        return 0;
        if (n == 2)
        return Math.abs(h[n - 1] - h[n- 2]);
        if(dp[n]!=-1) return dp[n];
        int f=Math.abs(h[n-1]-h[n-2]) ;
        int s=Math.abs(h[n-1]-h[n-3]);
        dp[n]=Math.min(recur(h,n-1,dp)+f,recur(h,n-2,dp)+s);
        return dp[n];
    }
}


//{ Driver Code Starts.

// } Driver Code Ends