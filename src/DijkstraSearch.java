import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearch<V> extends Search<V>{
    private final Set<V> unsettledNodes;
    private final Map<V, Double> distances;
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        this.graph = graph;
        this.unsettledNodes = new HashSet<>();
        this.distances = new HashMap<>();

        dijkstra();
    }

    public void dijkstra() {
        unsettledNodes.add(source);
        distances.put(source, 0.0);

        while (!unsettledNodes.isEmpty()) {
            V node = getVertexWithMinimumWeight(unsettledNodes);
            unsettledNodes.remove(node);
            marked.add(node);
            for (V target : graph.adjacencyList(node)) {
                double currentDistance = getShortestDistance(node) + getDistance(node, target);
                if (currentDistance < getShortestDistance(target)) {
                    distances.put(target, currentDistance);
                    edgeTo.put(target, node);
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private double getDistance(V node, V target) {
        Vertex<V> nodeVertex = graph.getVertex(node);
        Vertex<V> targetVertex = graph.getVertex(target);
        Double weight = nodeVertex.getAdjVertices().get(targetVertex);
        if (weight != null) {return weight;}
        return Double.MAX_VALUE;
    }

    private V getVertexWithMinimumWeight(Set<V> vertices) {
        V minimum = null;
        for (V vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;}
        }
        return minimum;
    }

    private double getShortestDistance(V destination) {
        Double d = distances.get(destination);
        if (d != null) return d;
        else return Double.MAX_VALUE;
    }

}