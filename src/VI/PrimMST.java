package VI;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This implementation is adopted from CZ2001 - Algorithms, Nanyang Technological University
 * It's in an extremely ugly form, but I have to do this to prepare for my exam
 */

public class PrimMST {
    private double[] d;  /* distance of a fringe vertex from the tree */
    private int[] pi;  /* vertex connecting a fringe vertex to a tree vertex */
    private boolean[] S;  /* whether a vertex is in the minimum spanning tree being built */
    private PriorityQueue<Integer> pq;  /* queue of fringe vertices in the order of d[] */
    private EdgeWeightedUndirectedGraph G; /* the graph */

    @SuppressWarnings("unchecked")
    public PrimMST(EdgeWeightedUndirectedGraph G, int source) {
        d = new double[G.V()];
        pi = new int[G.V()];
        S = new boolean[G.V()];
        pq = new PriorityQueue(Comparator.comparingDouble(o -> d[(int) o]));
        this.G = G;

        // initialize
        for (int i = 1; i < G.V(); i++) {
            d[i] = Double.POSITIVE_INFINITY;
        }

        d[source] = 0;
        S[source] = true;
        pq.add(source);

        while(!pq.isEmpty()) {
            int u = pq.remove();
            S[u] = true;
            updateFringe(u);
        }
    }

    private void updateFringe(int v) {
        for (UndirectedEdge e : G.adj(v)) {
            int w = e.either() == v ? e.other(v) : e.either();  // w and v are adjacent vertices
            if (!S[w]) {  // if w is not in the MST
                if (d[w] == Double.POSITIVE_INFINITY) {  // in fringe, first time visit
                    d[w] = e.getWeight();  // update cut distance
                    pi[w] = v;
                    pq.add(w);
                }
                else if (e.getWeight() < d[w]) {  // in fringe, but not the first time visit. Relax the edge
                    d[w] = e.getWeight();  // update cut distance
                    pi[w] = v;
                }
            }
        }
    }

    public void printMST() {
        double sum = 0;
        for (int v = 1; v < G.V(); v++) {
            System.out.println(v + " - " + pi[v] + ", edge weight is " + d[v]);
            sum += d[v];
        }
        System.out.println("Total weight for the MST is " + sum);
    }



    public static void main(String[] args) {
        EdgeWeightedUndirectedGraph G = new EdgeWeightedUndirectedGraph(6);
        G.addEdge(new UndirectedEdge(1, 2, 2));
        G.addEdge(new UndirectedEdge(1, 3, 1));
        G.addEdge(new UndirectedEdge(1, 5, 4));
        G.addEdge(new UndirectedEdge(3, 5, 7));
        G.addEdge(new UndirectedEdge(2, 5, 5));
        G.addEdge(new UndirectedEdge(3, 4, 6));
        G.addEdge(new UndirectedEdge(2, 4, 3));
        G.addEdge(new UndirectedEdge(5, 4, 8));

        PrimMST mst = new PrimMST(G, 1);

        mst.printMST();


    }
}
