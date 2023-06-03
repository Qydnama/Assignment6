import java.util.*;

public class WeightedGraph<V> implements WeightedGraphInterface<V> {
    private final boolean undirected;
    private final Map<V, Vertex<V>> map;

    public WeightedGraph() {
        this.undirected = true;
        this.map = new HashMap<>();
    }
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.map = new HashMap<>();
    }

    @Override
    public void addVertex(V v) {
        if (!hasVertex(v)) map.put(v,new Vertex<>(v));
    }

    @Override
    public void addEdge(V source, V dest, double weight) {
        addVertex(source);addVertex(dest);
        if (hasEdge(source, dest) || source.equals(dest)) return;
        map.get(source).addAdjVertex(map.get(dest),weight);
        if (undirected) map.get(dest).addAdjVertex(map.get(source),weight);
    }
    @Override
    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    @Override
    public boolean hasEdge(V source, V dest) {
        if (hasVertex(source)) {
            return map.get(source).getAdjVertices().containsKey(map.get(dest));
        }
        return false;
    }

    @Override
    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;
        List<V> vertices = new LinkedList<>();
        for (Vertex<V> vertex : getEdges(v)) {
            vertices.add(vertex.getData());
        }
        return vertices;
    }

    @Override
    public Iterable<Vertex<V>> getEdges(V v) {
        if (!hasVertex(v)) return null;
        return map.get(v).getAdjVertices().keySet();
    }

    @Override
    public Iterable<V> getVertices() {
        return map.keySet();
    }
    @Override
    public Vertex<V> getVertex (V v) {
        return map.get(v);
    }

}