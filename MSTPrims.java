package ankur.graph;

import java.util.*;

public class MSTPrims {
    List<List<List<Integer>>> adj;
    MSTPrims(int v){
        adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
    }
    public void addEdge(int src, int dest, int wt){
        adj.get(src).add(new ArrayList<>(List.of(dest,wt)));
        adj.get(dest).add(new ArrayList<>(List.of(src,wt)));
    }
    public int mst(int v, List<List<List<Integer>>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));
        boolean[] vis = new boolean[v];

        pq.add(new Pair(0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            int wt = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();

            if(vis[node]){
                continue;
            }
            vis[node] = true;
            sum += wt;
            /*
            2 1
            vis - 0,2,1
            sum - 0+1+3
             */
            for(List<Integer> list : adj.get(node)){
                int edW = list.get(1);
                int adjNode = list.get(0);
                if(!vis[adjNode]){
                    pq.add(new Pair(adjNode,edW));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of vertices: ");
        int v = sc.nextInt();
        System.out.print("Enter no. of edges: ");
        int e = sc.nextInt();

        MSTPrims graph = new MSTPrims(v);
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            int cost = sc.nextInt();
            graph.addEdge(u,w,cost);
        }
        int minCostOfMST = graph.mst(v,graph.adj);
        System.out.println(minCostOfMST);
        System.out.println(graph.adj);
    }
}
class Pair{
    int node;
    int dist;

    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
