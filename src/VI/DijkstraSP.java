package VI;

import java.util.PriorityQueue;

/**
 * Created by LiuMingyu on 13/11/17.
 */

public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private PriorityQueue<DirectedEdge> pq;

    /**
     *
     * @param G edge-weighted digraph
     * @param s source vertex
     */
    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new PriorityQueue<>();

        for (int v = 0; v < G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;

        distTo[s] = 0.0;
        for (DirectedEdge e : G.adj(s)) pq.add(e);
        while (!pq.isEmpty()) relax(G, pq.remove());
    }

    /**
     * Only if the edge need to be relaxed will the end vertex of the edge's adjacent vertices will be
     * added to the priority queue (which is pq)
     * @param G edge-weighted digraph
     * @param edge the edge to be relaxed
     */
    private void relax(EdgeWeightedDigraph G, DirectedEdge edge) {
        for (DirectedEdge e : G.adj(edge.from())) {
            if (distTo[e.to()] > distTo[e.from()] + e.getWeight()) {  // need relaxed
                distTo[e.to()] = distTo[e.from()] + e.getWeight();
                edgeTo[e.to()] = e;
                for (DirectedEdge e2 : G.adj(e.to())) pq.add(e2);
            }
        }
    }

    public static void main(String[] args) {
//        EdgeWeightedDigraph G = new EdgeWeightedDigraph(9);
//
//        G.addEdge(new DirectedEdge(1, 2, 1));
//        G.addEdge(new DirectedEdge(1, 3, 3));
//        G.addEdge(new DirectedEdge(2, 3, 1));
//        G.addEdge(new DirectedEdge(3, 4, 6));
//        G.addEdge(new DirectedEdge(3, 5, 1));
//        G.addEdge(new DirectedEdge(2, 7, 5));
//        G.addEdge(new DirectedEdge(5, 6, 1));
//        G.addEdge(new DirectedEdge(6, 7, 1));
//        G.addEdge(new DirectedEdge(7, 8, 1));

        // for negative edges
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(5);
        G.addEdge(new DirectedEdge(1,2, 1));
        G.addEdge(new DirectedEdge(1, 3, 0));
        G.addEdge(new DirectedEdge(1, 4, 99));
        G.addEdge(new DirectedEdge(2, 3, 1));
        G.addEdge(new DirectedEdge(4, 2, -300));


        DijkstraSP sp = new DijkstraSP(G, 1);

        int target = 3;
        while (sp.edgeTo[target] != null) {
            System.out.println(sp.edgeTo[target]);
            target = sp.edgeTo[target].from();
        }
    }
}
