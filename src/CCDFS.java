import java.util.Arrays;

public class CCDFS {

    private Graph G;
    private int[] visited;
    private int ccount = 0;

    public CCDFS(Graph G) {

        this.G = G;
        visited = new int[G.V()];
        Arrays.fill(visited, -1);

        for (int v = 0; v < G.V(); v++)
            if (visited[v] == -1) {
                dfs(v, ccount);
                ccount++;
            }
    }

    private void dfs(int v, int ccid) {

        visited[v] = ccid;
        for (int w : G.adj(v))
            if (visited[w] == -1)
                dfs(w, ccid);
    }

    public int ccount(){
        for (int e: visited)
            System.out.print(e + " ");
        System.out.println();
        return ccount;
    }

    public static void main(String[] args) {

        // 连通分量为1的图
        Graph g2 = new Graph("g2.txt");
        CCDFS ccDFS2 = new CCDFS(g2);
        System.out.println(ccDFS2.ccount());

        // 连通分量为2的图
        Graph g3 = new Graph("g3.txt");
        CCDFS ccDFS3 = new CCDFS(g3);
        System.out.println(ccDFS3.ccount());
    }
}