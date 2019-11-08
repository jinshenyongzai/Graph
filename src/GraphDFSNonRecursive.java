import java.util.ArrayList;
import java.util.Stack;

public class GraphDFSNonRecursive {

    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<>();

    public GraphDFSNonRecursive(Graph G) {

        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    // 从顶点v开始，进行非递归的深度优先遍历
    private void dfs(int v) {

        Stack<Integer> stack = new Stack<>();

        // 首先将v压入栈，同时，要记录visited[v]为true
        stack.push(v);
        visited[v] = true;

        // 只要栈不为空，说明还有未被遍历的节点
        while (!stack.empty()) {

            // 遍历栈顶元素
            int cur = stack.pop();
            pre.add(cur);

            // 由于二叉树只有左右两个孩子，所以分别将他们压入栈就好了
            // 但是对于图，和 cur 相邻的顶点可能有多个，需要这个循环
            for (int w : G.adj(cur))
                // 每次遍历到一个和 cur 相邻的顶点 w，别忘了判断一下 w 是否已经被访问过了
                if (!visited[w]) {
                    // 如果 w 没有被访问过，将 w 压入栈中，等待后续遍历
                    stack.push(w);
                    visited[w] = true;
                }
        }
    }

    // 图的深度优先先序遍历的返回结果
    public Iterable<Integer> pre() {
        return pre;
    }

    public static void main(String[] args) {

        // 连通分量为1的图
        // Graph g = new Graph("g2.txt");
        // 连通分量为2的图
        Graph g = new Graph("g3.txt");
        GraphDFSNonRecursive graphDFSNonRecursive = new GraphDFSNonRecursive(g);
        System.out.println(graphDFSNonRecursive.pre());
    }
}
