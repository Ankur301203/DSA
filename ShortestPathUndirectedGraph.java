package ankur.graph;

import java.util.*;

public class ShortestPathUndirectedGraph {
    List<List<Integer>> adjList;
    ShortestPathUndirectedGraph(int v){
        this.adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    /*
    * 0->1,2
    * 1->0,2,3
    * 2->0,1,3
    * 3->1,2
    * queue->
    * 0 1 0 0
    * 0 1 1 0
    * 0 1 1 2
    * 0 1 1 2
    * */
    public int[] shortestPath(List<List<Integer>> adjList, int src, boolean[] vis){
        int[] dist = new int[adjList.size()];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        Queue<Integer> qe = new LinkedList<>();
        qe.add(src);
        vis[src] = true;
        while (!qe.isEmpty()){
            int curr = qe.poll();
            for(int node : adjList.get(curr)){
                if(!vis[node]){
                    dist[node] = dist[curr] + 1;
                    vis[node] = true;
                    qe.add(node);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. of nodes: ");
        int v = sc.nextInt();

        System.out.print("Enter no. of edges: ");
        int e = sc.nextInt();

        ShortestPathUndirectedGraph graph = new ShortestPathUndirectedGraph(v);

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            graph.addEdge(u,w);
        }
        boolean[] visited = new boolean[v];
        List<List<Integer>> adjList = graph.adjList;

        for(int i=0;i<v;i++){
            if(!visited[i]){
                int[] dist = graph.shortestPath(adjList,i,visited);
                System.out.println(Arrays.toString(dist));
            }
        }
        System.out.println(adjList);

    }
}
