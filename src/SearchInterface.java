public interface SearchInterface<V> {

    boolean hasPathTo(V v);
    Iterable<V> pathTo(V v);
}
