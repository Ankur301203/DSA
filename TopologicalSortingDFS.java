package ankur.graph;

import java.util.*;

public class TopologicalSortingDFS{
    List<List<Integer>> adj;
    TopologicalSortingDFS(int v){
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdgeDirected(int src, int destination){
        adj.get(src).add(destination);
    }
    List<Integer> topoSort(int v, List<List<Integer>> adj){
        boolean[] vis = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(i,vis,stack, adj);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.peek());
            stack.pop();
        }
        return ans;
    }
    void dfs(int src, boolean[] vis, Stack<Integer> stack, List<List<Integer>> adj){
        vis[src] = true;
        for(int node : adj.get(src)){
            if(!vis[node]){
                dfs(node,vis,stack,adj);
            }
        }
        stack.push(src);
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter no. of vertices: ");
//        int v = sc.nextInt();
//
//        System.out.print("Enter no. of edges: ");
//        int e = sc.nextInt();
//
//        TopologicalSortingDFS graph = new TopologicalSortingDFS(v);
//        for (int i = 0; i < e; i++) {
//            int u = sc.nextInt();
//            int w = sc.nextInt();
//            graph.addEdgeDirected(u,w);
//        }
//        List<List<Integer>> adj = graph.adj;
//        List<Integer> toposort = graph.topoSort(v,adj);
//        System.out.println(toposort);
//
//        List<Integer> list = new ArrayList<>();



    }
}
