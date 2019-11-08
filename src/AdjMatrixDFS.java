import java.util.ArrayList;

public class AdjMatrixDFS {

    private AdjMatrix G;
    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    // 时间复杂度：O（V^2）
    public AdjMatrixDFS(AdjMatrix G) {

        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    private void dfs(int v) {

        visited[v] = true;
        pre.add(v);
        for (int w : G.adj(v))
            if (!visited[w])
                dfs(w);
        post.add(v);
    }

    // 图的深度优先先序遍历的返回结果
    public Iterable<Integer> pre() {
        return pre;
    }

    // 图的深度优先后序遍历的返回结果
    public Iterable<Integer> post() {
        return post;
    }

    public static void main(String[] args) {

        // 连通分量为1的图
        // Graph g = new Graph("g2.txt");
        // 连通分量为2的图
        AdjMatrix g = new AdjMatrix("g3.txt");
        AdjMatrixDFS adjMatrixDFS = new AdjMatrixDFS(g);
        System.out.println(adjMatrixDFS.pre());
        System.out.println(adjMatrixDFS.post());
    }
}