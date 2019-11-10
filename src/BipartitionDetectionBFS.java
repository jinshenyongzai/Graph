import java.util.LinkedList;
import java.util.Queue;

public class BipartitionDetectionBFS {

    private Graph G;

    private boolean[] visited;
    private int[] colors;
    private boolean isBipartite = true;

    public BipartitionDetectionBFS(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        for(int i = 0; i < G.V(); i ++)
            colors[i] = -1;

        for(int v = 0; v < G.V(); v ++)
            if(!visited[v])
                if(!bfs(v)){
                    isBipartite = false;
                    break;
                }
    }

    private boolean bfs(int s){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        colors[s] = 0;

        while(!queue.isEmpty()){
            int v = queue.remove();

            for(int w: G.adj(v))
                if(!visited[w]){
                    queue.add(w);
                    visited[w] = true;
                    colors[w] = 1 - colors[v];
                }
                else if(colors[v] == colors[w])
                    return false;
        }
        return true;
    }

    public boolean isBipartite(){
        return isBipartite;
    }

    public static void main(String[] args){

        Graph g = new Graph("g.txt");
        BipartitionDetectionBFS bipartitionDetectionBFS = new BipartitionDetectionBFS(g);
        System.out.println(bipartitionDetectionBFS.isBipartite);

        Graph g2 = new Graph("g4.txt");
        BipartitionDetectionBFS bipartitionDetectionBFS2 = new BipartitionDetectionBFS(g2);
        System.out.println(bipartitionDetectionBFS2.isBipartite);

        Graph g3 = new Graph("g5.txt");
        BipartitionDetectionBFS bipartitionDetectionBFS3 = new BipartitionDetectionBFS(g3);
        System.out.println(bipartitionDetectionBFS3.isBipartite);
    }
}