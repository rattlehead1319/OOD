package policies;

import exceptions.InvalidElementException;

public interface EvictionPolicy<K,V> {

    void setRecentlyAccessedKey(K key, V Value);
    K evict();
    void printElements();
}
