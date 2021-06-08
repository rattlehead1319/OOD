package datastructure;

public class DoublyLinkedListNode<K,V> {
    DoublyLinkedListNode<K,V> next;
    DoublyLinkedListNode<K,V> prev;
    private K key;
    private V value;

    DoublyLinkedListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }
}
