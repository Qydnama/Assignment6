public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }
    private void dfs(WeightedGraph<V> graph, V current) {
        marked.add(current);
        for (V adjVertex : graph.adjacencyList(current)) {
            if (!marked.contains(adjVertex)) {
                edgeTo.put(adjVertex, current);
                dfs(graph, adjVertex);
            }
        }
    }

}
