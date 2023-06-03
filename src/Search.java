import java.util.*;

public class Search<V> implements SearchInterface<V> {
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected final V source;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    @Override
    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    @Override
    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> ls = new LinkedList<>();
        for (V i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }
        ls.push(source);

        return ls;
    }

}