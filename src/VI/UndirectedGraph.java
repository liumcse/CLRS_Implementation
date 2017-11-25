package VI;

import java.util.LinkedList;

/**
 * Created by LiuMingyu on 13/11/17.
 */

public class UndirectedGraph {
    private final int V;  // number of vertices
    private int E;  // number of edges
    private LinkedList<Integer>[] adj;  // adjacency lists

    public UndirectedGraph(int V) {
        this.V = V;
        adj = new LinkedList[V];

        for (int v = 0; v < V; v++) {
            adj[v] = (LinkedList<Integer>) new LinkedList<Integer>();
        }
    }

    public int V() { return V; }

    public int E() { return E; }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
