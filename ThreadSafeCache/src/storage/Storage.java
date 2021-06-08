package storage;

public interface Storage<K,V> {
    void add(K key, V value);
    V get(K key);
    V remove(K key);
    boolean isFull();
    void printElements();
}
