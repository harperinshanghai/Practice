package Week4_ElementarySymbolTables;

public class ST<Key, Value> {
    public ST() {

    }

    public void put(Key key, Value value) {
    }

    public Value get(Key key) {
    }

    public void delete(Key key) {
        put(key, null);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpyt() {
    }

    public int size() {
    }

    public Iterable<Key> keys() {

    }
}
