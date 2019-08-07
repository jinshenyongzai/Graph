public class TreeDetectionBFS {

    private CCBFS CCBFS;
    private CycleDetectionBFS cycleDetectionBFS;

    public TreeDetectionBFS(Graph G){

        CCBFS = new CCBFS(G);
        cycleDetectionBFS = new CycleDetectionBFS(G);
    }

    public boolean isTree(){
        return CCBFS.count() == 1 && !cycleDetectionBFS.hasCycle();
    }

    public static void  main(String[] args){

        Graph g = new Graph("g3.txt");

        TreeDetectionBFS treeDetectionBFS = new TreeDetectionBFS(g);
        System.out.println(treeDetectionBFS.isTree());
    }
}
