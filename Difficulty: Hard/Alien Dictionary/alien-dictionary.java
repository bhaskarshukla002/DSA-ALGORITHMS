//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            String a=dict[i];
            String b=dict[i+1];
            int j=0;
            int len=Math.min(a.length(),b.length());
            while(j<len){
                int a1=a.charAt(j)-'a';
                int b1=b.charAt(j)-'a';
                if(a1!=b1){
                    adj.get(a1).add(b1);
                    break;
                }
                j++;
            }
        }
        
        int[] inDegree=new int[K];
        
        for(int i=0;i<K;i++){
        for(int it:adj.get(i))
            inDegree[it]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int it=0;it<K;it++){
            if(inDegree[it]==0)
                q.add(it);
        }
        // int i=0;
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            topo.add(node);
            // i++;
            for(int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0)
                    q.add(it);
            }
        }
        String s="";
        for(int i:topo){
            s=s+(char)('a'+i);
        }
        // Collections.sort(topo);
        return s;
        
        
    }
}