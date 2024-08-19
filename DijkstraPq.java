package ankur.graph;

import java.util.*;

public class DijkstraPq {
    List<List<Struct>> adj;
    DijkstraPq(int v){
        adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int destination, int cost){
        adj.get(src).add(new Struct(cost,destination));
        adj.get(destination).add(new Struct(cost,src));
    }
    public int[] dijkstra(int V, List<List<Struct>> adj, int src){
        PriorityQueue<Struct> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Struct(0,src));
        while(!pq.isEmpty()){
            int dis = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();

            for(Struct p : adj.get(node)){
                if(dis + p.dist < dist[p.node]){
                    dist[p.node] = dis + p.dist;
                    pq.add(new Struct(dist[p.node],p.node));
                }
            }
        }
        return dist;
    }
    public int[] dijkstraSet(int v, List<List<Struct>> adj, int src){
        int[] dist = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        TreeSet<Struct> set = new TreeSet<>();
        set.add(new Struct(0,src));

        while(!set.isEmpty()){
            Struct curr = set.pollFirst();
            int node = curr.node;
            int dis = curr.dist;


            for(Struct p : adj.get(node)){
                int adjNode = p.node;
                int edgeW = p.dist;
                if(dis + edgeW < dist[adjNode]){
                    // erase if it existed
                    if(dist[adjNode] != Integer.MAX_VALUE){
                        set.remove(new Struct(dist[adjNode],adjNode));
                    }

                    dist[adjNode] = dis + edgeW;
                    set.add(new Struct(dist[adjNode],adjNode));
                }
            }
        }

        return dist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of vertices: ");
        int v = sc.nextInt();
        System.out.print("Enter no.of edges: ");
        int e = sc.nextInt();

        DijkstraPq graph = new DijkstraPq(v);
        for(int i=0;i<e;i++){
            int u = sc.nextInt();
            int w = sc.nextInt();
            int cost = sc.nextInt();
            graph.addEdge(u,w,cost);
        }
        System.out.println(Arrays.toString(graph.dijkstraSet(v,graph.adj,0)));


    }

}
class Struct implements Comparable<Struct> {
    int dist;
    int node;

    public Struct(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
    @Override
    public int compareTo(Struct o){
        if(this.dist != o.dist){
            return Integer.compare(this.dist,o.dist);
        }
        return Integer.compare(this.node,o.node);
    }
    @Override
    public String toString() {
        return "dist=" + dist + " node=" + node;
    }
}
