package policies;

import datastructure.DoublyLinkedList;
import datastructure.DoublyLinkedListNode;
import exceptions.EmptyListException;
import exceptions.InvalidElementException;

public class LRUEvictionPolicy<K,V> implements EvictionPolicy<K,V> {

    private DoublyLinkedList<K,V> doublyLinkedList;

    public LRUEvictionPolicy(DoublyLinkedList<K,V> doublyLinkedList) {
        this.doublyLinkedList = doublyLinkedList;
    }

    @Override
    public void setRecentlyAccessedKey(K key, V value)  {
        try {
            doublyLinkedList.setRecentlyAccessedKey(key, value);
        } catch (InvalidElementException iee) {
            iee.printStackTrace();
        }
    }

    @Override
    public K evict() {
        K key = null;
        try {
            key = doublyLinkedList.getFirstKey();
        } catch (EmptyListException ele) {
            ele.printStackTrace();
        }
        return key;
    }

    @Override
    public void printElements() {
        doublyLinkedList.printElements();
    }
}
