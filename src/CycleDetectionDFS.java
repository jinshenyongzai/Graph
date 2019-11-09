public class CycleDetectionDFS {

    private Graph G;
    private boolean[] visited;
    private boolean hasCycle = false;

    public CycleDetectionDFS(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                if (dfs(v, v)){
                    hasCycle = true;
                    break;
                }
    }

    private boolean dfs(int v, int parent){

        visited[v] = true;
        for (int w: G.adj(v))
            if (!visited[w]) {
                if (dfs(w, v))
                    return true;
            }
            else if (w != parent)
                hasCycle = true;
        return false;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void  main(String[] args){

        Graph g = new Graph("g3.txt");

        CycleDetectionDFS cycleDetectionDFS = new CycleDetectionDFS(g);
        System.out.println(cycleDetectionDFS.hasCycle());

        Graph g2 = new Graph("g4.txt");

        CycleDetectionDFS cycleDetectionDFS2 = new CycleDetectionDFS(g2);
        System.out.println(cycleDetectionDFS2.hasCycle());
    }
}
