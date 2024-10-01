//{ Driver Code Starts
import java.util.*;
class Disjoint{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n+1];
			for(int i=1;i<=n;i++)
				a[i]=i;
			int k=sc.nextInt();
			GfG g=new GfG();
			for(int i=0;i<k;i++){
				String s=sc.next();
				if(s.equals("UNION")){
					int x=sc.nextInt();
					int z=sc.nextInt();
					g.unionSet(a,x,z);
				}
				else{
					int x=sc.nextInt();
					int parent=g.find(a,x);
					System.out.print(parent+" ");
				}
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
    List<Integer> parent=new ArrayList<>();
    
	int find(int A[],int X)
    {
          //add code here.
          while(A[X]!=X){
              X=A[X];
          }
          return A[X];
	}
	void unionSet(int A[],int X,int Z)
    {
         //add code here.
         int rX=find(A,X);
         int rZ=find(A,Z);
         if(rX!=rZ){
             A[rX]=rZ;
         }
	}
}
