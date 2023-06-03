import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjVertices;
    public Vertex(V data) {
        this.data = data;
        this.adjVertices = new HashMap<>();
    }
    public void addAdjVertex(Vertex<V> dest, double weight) {
        adjVertices.put(dest,weight);
    }

    public V getData() {
        return data;
    }
    public Map<Vertex<V>, Double> getAdjVertices() {
        return adjVertices;
    }

}
