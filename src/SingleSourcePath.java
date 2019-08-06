import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SingleSourcePath {

    private Graph G;
    private int s;

    private boolean[] visited;
    private int[] pre;

    public SingleSourcePath(Graph G, int s){

        G.validateVertex(s);

        this.G = G;
        this.s = s;

        visited = new boolean[G.V()];
        pre = new int[G.V()];
        Arrays.fill(pre, -1);

        dfs(s, s);
    }

    public boolean isConnectedTo(int t){
        G.validateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(int t){

        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnectedTo(t))
            return res;

        int cur = t;
        while(cur != s){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        Collections.reverse(res);
        return res;
    }

    private void dfs(int v, int parent){

        visited[v] = true;
        pre[v] = parent;
        for (int w: G.adj(v))
            if (!visited[w])
                dfs(w, v);
    }

    public static void  main(String[] args){

        Graph g = new Graph("g.txt");

        SingleSourcePath ssPath = new SingleSourcePath(g, 0);
        System.out.println("0 -> 0 : " + ssPath.path(0));
        System.out.println("0 -> 1 : " + ssPath.path(1));
        System.out.println("0 -> 2 : " + ssPath.path(2));
        System.out.println("0 -> 3 : " + ssPath.path(3));
        System.out.println("0 -> 4 : " + ssPath.path(4));
        System.out.println("0 -> 5 : " + ssPath.path(5));
        System.out.println("0 -> 6 : " + ssPath.path(6));
    }
}
