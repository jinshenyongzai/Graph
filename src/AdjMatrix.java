import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix implements GraphInterface{

    private int V;
    private int E;
    private int[][] adj;

    // 空间复杂度：O（V^2)
    public AdjMatrix(String filename){

        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)){

            V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative");
            adj = new int[V][V];

            E = scanner.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("E must be non-negative");
            // 建图时间复杂度：O（E）
            for (int i = 0; i < E; i++){
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);

                // 去除自环边
                if (a == b)
                    throw new IllegalArgumentException("Self Loop is Detected!");
                // 去除平行边
                if (adj[a][b] == 1)
                    throw new IllegalArgumentException("Parallel Edges are Detected!");

                adj[a][b] = 1;
                adj[b][a] = 1;
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

    // 查看两个节点是否相邻，时间复杂度：O（1）
    public boolean hasEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }

    // 求一个顶点的相邻节点，时间复杂度：O（V）
    public ArrayList<Integer> adj(int v){

        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++)
            if (adj[v][i] == 1)
                res.add(i);
        return res;
    }

    // 求一个顶点的度
    public int degree(int v){
        return adj(v).size();
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++)
                sb.append(String.format("%d ", adj[i][j]));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args){

        AdjMatrix adjMatrix = new AdjMatrix("g.txt");

        System.out.print("邻接矩阵：\n" + adjMatrix);
        System.out.println("顶点个数：" + adjMatrix.V);
        System.out.println("边的条数：" + adjMatrix.E);
    }
}