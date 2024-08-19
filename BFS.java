package ankur.graph;

import java.util.*;

public class BFS {

    List<List<Integer>> adjList;

    BFS(int v){
        adjList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
        public String toString(){
            return "("+first+" "+second+")";
        }
    }
    private static void bfs(int row, int col, boolean[][] visited, char[][] grid){
        visited[row][col] = true;
        Queue<Pair> qe = new LinkedList<>();
        qe.add(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;

        while (!qe.isEmpty()){
            int row1 = qe.peek().first;
            int col1 = qe.peek().second;
            qe.remove();

            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <= 1; delCol++){
                    int nRow = row1 + delRow;
                    int nCol = col1 + delCol;
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                    && grid[nRow][nCol] == '1' && visited[nRow][nCol] == false){
                        visited[nRow][nCol] = true;
                        qe.add(new Pair(nRow,nCol));
                    }
                }
            }
        }

    }

    public static int numOfIslands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == '1'){
                    cnt++;
                    bfs(i,j,visited,grid);
                }
            }
        }
        return cnt;
    }
    public void addEdge(int source, int destination){
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }
    public ArrayList<Integer> bfsOfGraph(int v, List<List<Integer>> adj){

        ArrayList<Integer> bfs =  new ArrayList<>();
        boolean[] visited = new boolean[v];

        Queue<Integer> qe = new LinkedList<>();
        qe.add(0);
        visited[0] = true;

        while (!qe.isEmpty()){
            int node = qe.poll();

            bfs.add(node);

            for(int i : adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    qe.add(i);
                }
            }
        }
        return bfs;
    }
    public List<Integer> bfs(List<List<Integer>> adj, int v){
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> qe = new LinkedList<>();
        boolean[] visited = new boolean[v];
        qe.add(0);
        visited[0] = true;

        while (!qe.isEmpty()){
            int currNode = qe.poll();
            answer.add(currNode);

            for(int i : adj.get(currNode)){
                if(!visited[i]){
                    visited[i] = true;
                    qe.add(i);
                }
            }
        }
        return answer;
    }
    public List<Integer> bfs1(List<List<Integer>> adjList, int v, boolean[] visited){
        List<Integer> resultList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            resultList.add(node);

            for(int eachNode : adjList.get(node)){
                if(!visited[eachNode]){
                    visited[eachNode] = true;
                    queue.add(eachNode);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter no. of edges: ");
        int e = sc.nextInt();

        BFS graph = new BFS(v);

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            graph.addEdge(u,w);
        }

//        List<Integer> traversedGraph = graph.bfs1(graph.adjList,v);
//
//        System.out.println(traversedGraph);
        int connectedComponentsCount = 0;
        boolean[] visited = new boolean[v+1];
        for (int i = 0; i < v; i++) {
            if(!visited[i]){
                List<Integer> list = graph.bfs1(graph.adjList,i,visited);
                System.out.println(list);
                connectedComponentsCount++;
            }
        }
        System.out.println(graph.adjList);
        System.out.println(connectedComponentsCount);
    }
}