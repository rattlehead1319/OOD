package cache;

import policies.EvictionPolicy;
import storage.Storage;

import java.util.Iterator;

public class CacheImplementation<K,V> implements Cache<K,V> {

    private Storage<K,V> storage;
    private EvictionPolicy<K,V> evictionPolicy;

    public CacheImplementation(Storage<K,V> storage, EvictionPolicy<K,V> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public void put(K key, V value) {
        if (this.storage.isFull()) {
            K keyToEvict = this.evictionPolicy.evict();
            this.storage.remove(keyToEvict);
        }
        this.storage.add(key, value);
        this.evictionPolicy.setRecentlyAccessedKey(key, value);
    }

    @Override
    public V get(K key) {
        V value = this.storage.get(key);
        this.evictionPolicy.setRecentlyAccessedKey(key, value);
        return value;
    }

    public void printElements() {
        this.evictionPolicy.printElements();
    }
}
