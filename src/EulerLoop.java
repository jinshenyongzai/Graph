public class EulerLoop {

    private Graph G;

    public EulerLoop(Graph G) {
        this.G = G;
    }

    public boolean hasEulerLoop(){

        CCDFS ccdfs = new CCDFS(G);
        if (ccdfs.ccount() > 1)
            return false;

        for (int v = 0; v < G.V(); v++)
            if (G.degree(v) % 2 == 1)
                return false;
        return true;
    }

    public static void main(String[] args) {

        Graph g = new Graph("g.txt");
        EulerLoop eulerLoop = new EulerLoop(g);
        System.out.println(eulerLoop.hasEulerLoop());

        Graph g2 = new Graph("g2.txt");
        EulerLoop eulerLoop2 = new EulerLoop(g2);
        System.out.println(eulerLoop2.hasEulerLoop());

        Graph g3 = new Graph("g3.txt");
        EulerLoop eulerLoop3 = new EulerLoop(g3);
        System.out.println(eulerLoop3.hasEulerLoop());

        Graph g4 = new Graph("g4.txt");
        EulerLoop eulerLoop4 = new EulerLoop(g4);
        System.out.println(eulerLoop4.hasEulerLoop());

        Graph g5 = new Graph("g5.txt");
        EulerLoop eulerLoop5 = new EulerLoop(g5);
        System.out.println(eulerLoop5.hasEulerLoop());

        Graph g6 = new Graph("g6.txt");
        EulerLoop eulerLoop6 = new EulerLoop(g6);
        System.out.println(eulerLoop6.hasEulerLoop());

        Graph g7 = new Graph("g7.txt");
        EulerLoop eulerLoop7 = new EulerLoop(g7);
        System.out.println(eulerLoop7.hasEulerLoop());

        Graph g8 = new Graph("g8.txt");
        EulerLoop eulerLoop8 = new EulerLoop(g8);
        System.out.println(eulerLoop8.hasEulerLoop());

        Graph g9 = new Graph("g9.txt");
        EulerLoop eulerLoop9 = new EulerLoop(g9);
        System.out.println(eulerLoop9.hasEulerLoop());

        Graph g10 = new Graph("g10.txt");
        EulerLoop eulerLoop10 = new EulerLoop(g10);
        System.out.println(eulerLoop10.hasEulerLoop());
    }
}
