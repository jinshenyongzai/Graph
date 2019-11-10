import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;


public class SingleSourcePathBFS {

    private Graph G;
    private int s;

    private boolean[] visited;
    private int[] pre;

    public SingleSourcePathBFS(Graph G, int s){

        this.G = G;
        this.s = s;

        visited = new boolean[G.V()];
        pre = new int[G.V()];
        Arrays.fill(pre, -1);

        bfs(s);
    }

    private void bfs(int s){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        pre[s] = s;
        while(!queue.isEmpty()){
            int v = queue.remove();

            for(int w: G.adj(v))
                if(!visited[w]){
                    queue.add(w);
                    visited[w] = true;
                    pre[w] = v;
                }
        }
    }

    public boolean isConnectedTo(int t){
        G.validateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(int t){

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(!isConnectedTo(t)) return res;

        int cur = t;
        while(cur != s){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        Collections.reverse(res);
        return res;
    }

    public static void  main(String[] args){

        Graph g = new Graph("g.txt");

        SingleSourcePathBFS ssPath = new SingleSourcePathBFS(g, 0);
        System.out.println("0 -> 0 : " + ssPath.path(0));
        System.out.println("0 -> 1 : " + ssPath.path(1));
        System.out.println("0 -> 2 : " + ssPath.path(2));
        System.out.println("0 -> 3 : " + ssPath.path(3));
        System.out.println("0 -> 4 : " + ssPath.path(4));
        System.out.println("0 -> 5 : " + ssPath.path(5));
        System.out.println("0 -> 6 : " + ssPath.path(6));
    }
}
