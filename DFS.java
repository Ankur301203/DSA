package ankur.graph;

import java.util.*;

public class DFS {
    List<List<Integer>> adjList;

    DFS(int v){
        adjList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination){
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> adj,
                   List<Integer> ans){
        visited[node] = true;
        ans.add(node);

        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(i, visited, adj, ans);
            }
        }
    }
    public List<Integer> dfsOfGraph(List<List<Integer>> adj, int v, boolean[] visited){
//        boolean[] visited = new boolean[v+1];
        List<Integer> ans = new ArrayList<>();
        dfs(v , visited, adj, ans);
        return ans;
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter no. of vertices: ");
//        int v = sc.nextInt();
//
//        System.out.print("Enter no. of edges: ");
//        int e = sc.nextInt();
//
//        DFS graph = new DFS(v);
//
//        for (int i = 0; i < e; i++) {
//            int s = sc.nextInt();
//            int d = sc.nextInt();
//            graph.addEdge(s,d);
//        }
//        boolean[] vis = new boolean[v];
//        for (int i = 0; i < v; i++) {
//            if(!vis[i]){
//                List<Integer> list = graph.dfsOfGraph(graph.adjList,i,vis);
//                System.out.println(list);
//            }
//        }


//        List<Integer> dfsTraversedGraph = graph.dfsOfGraph(graph.adjList,v);
//
//        System.out.println(dfsTraversedGraph);

        List<Integer> res = new ArrayList<>();
    }


}

