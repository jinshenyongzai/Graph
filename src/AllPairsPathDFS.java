public class AllPairsPathDFS {

    private Graph G;
    private SingleSourcePathDFS[] paths;

    public AllPairsPathDFS(Graph G){

        this.G = G;

        paths = new SingleSourcePathDFS[G.V()];
        for (int v = 0; v < G.V(); v++)
            paths[v] = new SingleSourcePathDFS(G, v);
    }

    public boolean isConnectedTo(int s, int t){
        G.validateVertex(s);
        return paths[s].isConnectedTo(t);
    }

    public Iterable<Integer> path(int s, int t){
        G.validateVertex(s);
        return paths[s].path(t);
    }

    public static void  main(String[] args){

        Graph g = new Graph("g.txt");

        AllPairsPathDFS apPath = new AllPairsPathDFS(g);
        System.out.println("0 -> 1 : " + apPath.paths[0].path(1));
        System.out.println("0 -> 3 : " + apPath.paths[0].path(3));
        System.out.println("0 -> 5 : " + apPath.paths[0].path(5));

        System.out.println("2 -> 1 : " + apPath.paths[2].path(1));
        System.out.println("2 -> 3 : " + apPath.paths[2].path(3));
        System.out.println("2 -> 5 : " + apPath.paths[2].path(5));
    }
}
