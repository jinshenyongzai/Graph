import java.util.ArrayList;
import java.util.Collections;

public class SingleSourcePathDFS {

    private Graph G;
    private int s;

    private boolean[] visited;
    private int[] pre;

    public SingleSourcePathDFS(Graph G, int s) {

        G.validateVertex(s);

        this.G = G;
        this.s = s;

        visited = new boolean[G.V()];
        pre = new int[G.V()];

        dfs(s, s);
    }

    private void dfs(int v, int parent) {

        visited[v] = true;
        pre[v] = parent;
        for (int w : G.adj(v))
            if (!visited[w])
                dfs(w, v);
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

    public static void main(String[] args) {

        // 连通分量为1的图
        // Graph g = new Graph("g2.txt");
        // 连通分量为2的图
        Graph g = new Graph("g3.txt");
        SingleSourcePathDFS sspath = new SingleSourcePathDFS(g, 0);
        System.out.println("0 -> 6 : " + sspath.path(6));
        System.out.println("0 -> 5 : " + sspath.path(5));
    }
}
