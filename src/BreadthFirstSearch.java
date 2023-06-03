import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V>{

    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V current) {
        marked.add(current);
        Queue<V> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            V currentVertex = queue.remove();
            for (V adjVertex : graph.adjacencyList(currentVertex)) {
                if (!marked.contains(adjVertex)) {
                    marked.add(adjVertex);
                    edgeTo.put(adjVertex, currentVertex);
                    queue.add(adjVertex);
                }
            }
        }
    }
}
