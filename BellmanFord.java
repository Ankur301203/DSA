package ankur.graph;

import java.util.*;

public class BellmanFord {
    List<List<Integer>> adj;
    BellmanFord(int v){
        for (int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist,(int)(1e8));
        dist[S] = 0;
        for(int i=0;i<V;i++){
            for(List<Integer> list : edges){
                int u = list.get(0);
                int v = list.get(1);
                int w = list.get(2);
                if(dist[u] != 1e8 && dist[u]+w < dist[v]){
                    dist[v] = dist[u]+w;
                }
            }
        }
        for(List<Integer> list : edges){
            int u = list.get(0);
            int v = list.get(1);
            int w = list.get(2);
            if(dist[u] != 1e8 && dist[u]+w < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
    public static void main(String[] args) {

    }
}
