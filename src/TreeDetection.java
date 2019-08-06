public class TreeDetection {

    private Graph G;
    private CC cc;
    private CycleDetection cycleDetection;

    public TreeDetection(Graph G){

        this.G = G;
        cc = new CC(G);
        cycleDetection = new CycleDetection(G);
    }

    public boolean isTree(){
        return cc.count() == 1 && !cycleDetection.hasCycle();
    }

    public static void  main(String[] args){

        Graph g = new Graph("g3.txt");

        TreeDetection treeDetection = new TreeDetection(g);
        System.out.println(treeDetection.isTree());
    }
}
