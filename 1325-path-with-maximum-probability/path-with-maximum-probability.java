class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<Pair<Integer,Double>>> adj=new ArrayList<>();
        PriorityQueue<Pair<Double, Integer>> pq=new PriorityQueue<>((a,b)-> -Double.compare(a.getKey(),b.getKey()));
        double dij[]=new double[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        pq.add(new Pair<>(1.0,start_node));
        dij[start_node]=1d;
        while(!pq.isEmpty()){
            Pair<Double,Integer> p=pq.poll();
            int node=p.getValue();
            double totalSucc=p.getKey();
            if(node==end_node){
                return totalSucc;
            }
            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i).getKey();
                double pro=adj.get(node).get(i).getValue();
                if(pro*totalSucc>dij[v]){
                    dij[v]=pro*totalSucc;
                    pq.add(new Pair<>(dij[v],v));
                }
            }
        }
        return 0d;
    }
}