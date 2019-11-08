import java.io.File;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Scanner;

public class AdjSet implements GraphInterface{

    private int V;
    private int E;
    private TreeSet<Integer>[] adj;

    // 空间复杂度：O（V + E)
    public AdjSet(String filename){

        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)){

            V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative");
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++)
                adj[i] = new TreeSet<Integer>();

            E = scanner.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("E must be non-negative");
            // 建图时间复杂度：O（E * logV）
            for (int i = 0; i < E; i++){
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);

                // 去除自环边
                if (a == b)
                    throw new IllegalArgumentException("Self Loop is Detected!");
                // 去除平行边
                if (adj[a].contains(b))
                    throw new IllegalArgumentException("Parallel Edges are Detected!");

                adj[a].add(b);
                adj[b].add(a);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    // 顶点合法性判定
    private void validateVertex(int v){
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex" + v + "is invalid");
    }

    // 返回顶点个数
    public int V(){
        return V;
    }

    // 返回边的条数
    public int E(){
        return E;
    }

    // 查看两个节点是否相邻，时间复杂度：O（logV)
    public boolean hasEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    // 求一个顶点的相邻节点，时间复杂度：O（degree(v))
    public Iterable<Integer> adj(int v){

        validateVertex(v);
        return adj[v];
    }

    // 求一个顶点的度
    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++){
            sb.append(String.format("%d : ", i));
            for (int w : adj[i])
                sb.append(String.format("%d ", w));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args){

        AdjSet adjSet = new AdjSet("g.txt");

        System.out.print("邻接表：\n" + adjSet);
        System.out.println("顶点个数：" + adjSet.V);
        System.out.println("边的条数：" + adjSet.E);
    }
}
