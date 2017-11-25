package VI;

import java.util.LinkedList;

/**
 * Created by LiuMingyu on 25/11/17.
 */

public class EdgeWeightedUndirectedGraph {
    private final int V;  // number of vertices
    private int E;  // number of edges
    private LinkedList<UndirectedEdge>[] adj;  // adjacency lists

    @SuppressWarnings("unchecked")
    public EdgeWeightedUndirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<UndirectedEdge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public int V() { return V; }

    public int E() { return E; }

    public void addEdge(UndirectedEdge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<UndirectedEdge> adj(int v) { return adj[v]; }

}

class UndirectedEdge implements Comparable {
    private final int v;  // edge source
    private final int w;  // edge target
    private final double weight;  // edge weight

    public UndirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either() { return v; }

    public int other(int vertex)
    {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.weight, ((UndirectedEdge)o).weight);
    }
}