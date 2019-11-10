import java.util.ArrayList;
import java.util.Collections;

public class HamiltLoop {

    private Graph G;
    private boolean[] visited;
    private int[] pre;
    private int end;

    public HamiltLoop(Graph G) {

        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        end = -1;

        dfs(0, 0);
    }

    private boolean dfs(int v, int parent) {

        visited[v] = true;
        pre[v] = parent;

        for (int w : G.adj(v))
            if (!visited[w]) {
                if (dfs(w, v))
                    return true;
            }
            else if (w == 0 && allVisited()){
                end = v;
                return true;
            }

        visited[v] = false;
        return false;
    }

    private boolean allVisited(){
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                return false;
        return true;
    }

    public ArrayList<Integer> result(){

        ArrayList<Integer> res = new ArrayList<>();
        if (end == -1)
            return res;

        int cur = end;
        while (cur != 0){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(0);

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

        Graph g = new Graph("g8.txt");
        HamiltLoop hl = new HamiltLoop(g);
        System.out.println(hl.result());

        Graph g2 = new Graph("g9.txt");
        HamiltLoop hl2 = new HamiltLoop(g2);
        System.out.println(hl2.result());
    }
}