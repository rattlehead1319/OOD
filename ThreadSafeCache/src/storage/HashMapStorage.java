package storage;

import java.util.*;

public class HashMapStorage<K,V> implements Storage<K,V> {

    private Map<K,V> map;
    private int capacity;

    public HashMapStorage(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public void add(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public V remove(K key) {
        return map.remove(key);
    }

    @Override
    public boolean isFull() {
        return map.size() == capacity;
    }

    @Override
    public void printElements() {
        for (Map.Entry<K,V> entry: map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();
    }
}
