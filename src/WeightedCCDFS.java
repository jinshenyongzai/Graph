import java.util.ArrayList;
import java.util.Arrays;

public class WeightedCCDFS {

    private WeightedGraph G;
    private int[] visited;
    private int ccount = 0;

    public WeightedCCDFS(WeightedGraph G) {

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
//        for (int e: visited)
//            System.out.print(e + " ");
//        System.out.println();
        return ccount;
    }

    public boolean isConnected(int v, int w){
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    public ArrayList<Integer>[] components(){

        ArrayList<Integer>[] res = new ArrayList[ccount];
        for (int i = 0; i < ccount; i++)
            res[i] = new ArrayList<>();

        for (int v = 0; v < G.V(); v++)
            res[visited[v]].add(v);
        return res;
    }
}
