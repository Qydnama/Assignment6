public interface WeightedGraphInterface<V> {
    void addVertex(V v);
    void addEdge(V source, V dest, double weight);
    boolean hasVertex(V v);
    boolean hasEdge(V source, V dest);
    Iterable<V> adjacencyList(V v);
    Iterable<Vertex<V>> getEdges(V v);
    Iterable<V> getVertices();
    Vertex<V> getVertex (V v);
}
