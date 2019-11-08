public class CCDFS {

    private Graph G;
    private boolean[] visited;
    private int ccount = 0;

    public CCDFS(Graph G) {

        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v]) {
                dfs(v);
                ccount++;
            }
    }

    private void dfs(int v) {

        visited[v] = true;
        for (int w : G.adj(v))
            if (!visited[w])
                dfs(w);
    }

    public int ccount(){
        return ccount;
    }

    public static void main(String[] args) {

        // 连通分量为1的图
        Graph g2 = new Graph("g2.txt");
        CCDFS ccDFS2 = new CCDFS(g2);
        System.out.println(ccDFS2.ccount);

        // 连通分量为2的图
        Graph g3 = new Graph("g3.txt");
        CCDFS ccDFS3 = new CCDFS(g3);
        System.out.println(ccDFS3.ccount);
    }
}