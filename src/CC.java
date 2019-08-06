import java.util.ArrayList;
import java.util.Arrays;

public class CC {

    private Graph G;
    private int[] visited;
    private int ccount = 0;

    public CC(Graph G){

        this.G = G;
        visited = new int[G.V()];
        Arrays.fill(visited, -1);

        for (int v = 0; v < G.V(); v++)
            if (visited[v] == -1) {
                dfs(v, ccount);
                ccount++;
            }
    }

    private void dfs(int v, int ccid){

        visited[v] = ccid;
        for (int w: G.adj(v))
            if (visited[w] == -1)
                dfs(w, ccid);
    }

    public int count(){

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

    public static void  main(String[] args){

        Graph g = new Graph("g.txt");

        CC cc = new CC(g);
        System.out.println(cc.count());

        System.out.println(cc.isConnected(0, 6));
        System.out.println(cc.isConnected(0, 5));

        ArrayList<Integer>[] comp =  cc.components();
        for (int ccid = 0; ccid < comp.length; ccid++){
            System.out.print(ccid + " : ");
            for (int w: comp[ccid])
                System.out.print(w + " ");
            System.out.println();
        }
    }
}
