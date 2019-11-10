public class TreeDetectionDFS {

    private CCDFS CCDFS;
    private CycleDetectionDFS cycleDetectionDFS;

    public TreeDetectionDFS(Graph G){

        CCDFS = new CCDFS(G);
        cycleDetectionDFS = new CycleDetectionDFS(G);
    }

    public boolean isTree(){
        return CCDFS.ccount() == 1 && !cycleDetectionDFS.hasCycle();
    }

    public static void  main(String[] args){

        Graph g = new Graph("g3.txt");

        TreeDetectionDFS treeDetectionDFS = new TreeDetectionDFS(g);
        System.out.println(treeDetectionDFS.isTree());
    }
}
