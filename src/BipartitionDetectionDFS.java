import java.util.ArrayList;
import java.util.Arrays;

public class BipartitionDetectionDFS {

    private Graph G;
    private boolean[] visited;
    private int[] colors;
    private boolean isBipartite = true;

    public BipartitionDetectionDFS(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        Arrays.fill(colors, -1);

        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                if (!dfs(v, 0)) {
                    isBipartite = false;
                    break;
                }
    }

    private boolean dfs(int v, int color){

        visited[v] = true;
        colors[v] = color;

        for (int w: G.adj(v))
            if (!visited[w]) {
                if (!dfs(w, 1 - color))
                    return false;
            }
            else if (colors[w] == colors[v])
                return false;
        return true;
    }

    public boolean isBipartite(){
        return isBipartite;
    }

    public ArrayList<Integer>[] components(){

        int n = 2;
        ArrayList<Integer>[] res = new ArrayList[n];
        for (int i = 0; i < n; i++)
            res[i] = new ArrayList<>();

        for (int v = 0; v < G.V(); v++)
            res[colors[v]].add(v);
        return res;
    }

    public static void  main(String[] args){

        Graph g = new Graph("g.txt");

        BipartitionDetectionDFS bipartitionDetection = new BipartitionDetectionDFS(g);
        System.out.println(bipartitionDetection.isBipartite());

        Graph g2 = new Graph("g4.txt");

        BipartitionDetectionDFS bipartitionDetection2 = new BipartitionDetectionDFS(g2);
        System.out.println(bipartitionDetection2.isBipartite());

        Graph g3 = new Graph("g5.txt");

        BipartitionDetectionDFS bipartitionDetection3 = new BipartitionDetectionDFS(g3);
        System.out.println(bipartitionDetection3.isBipartite());

        ArrayList<Integer>[] comp =  bipartitionDetection3.components();
        for (int ccid = 0; ccid < comp.length; ccid++){
            System.out.print(ccid + " : ");
            for (int w: comp[ccid])
                System.out.print(w + " ");
            System.out.println();
        }
    }
}
