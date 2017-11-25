package VI;

import java.util.LinkedList;

/**
 * Created by LiuMingyu on 13/11/17.
 */

public class EdgeWeightedDigraph {
    private final int V;  // number of vertices
    private int E;  // number of edges
    private LinkedList<DirectedEdge>[] adj;  // adjacency lists

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public int V() { return V; }

    public int E() { return E; }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    /**
     * Get the edge adjacent to node v
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v) { return adj[v]; }

    /**
     * Get all edges in the graph
     * @return
     */
    public Iterable<DirectedEdge> edges() {
        LinkedList<DirectedEdge> edges = new LinkedList<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) edges.add(e);
        }
        return edges;
    }
}

class DirectedEdge implements Comparable {
    private final int v;  // edge source
    private final int w;  // edge target
    private final double weight;  // edge weight

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.weight, ((DirectedEdge)o).weight);
    }
}