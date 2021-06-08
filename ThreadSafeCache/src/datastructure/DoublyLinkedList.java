package datastructure;

import exceptions.EmptyListException;
import exceptions.InvalidElementException;

import java.util.*;

public class DoublyLinkedList<K,V> {

    private DoublyLinkedListNode<K,V> head;
    private DoublyLinkedListNode<K,V> tail;
    private Map<K, DoublyLinkedListNode<K,V>> map;

    public DoublyLinkedList() {
        map = new HashMap<>();
    }

    public void setRecentlyAccessedKey(K key, V value) throws InvalidElementException {
        if (map.containsKey(key)) {
            DoublyLinkedListNode<K,V> node = detachNode(key);
            if (node == null) { //tail element, hence do nothing
                return;
            }
            addNodeAtLast(node);
        } else {
            DoublyLinkedListNode<K,V> newNode = new DoublyLinkedListNode<>(key, value);
            addNodeAtLast(newNode);
            map.put(key, newNode);
        }
    }

    private DoublyLinkedListNode<K,V> detachNode(K key) {
        DoublyLinkedListNode<K,V> node = map.get(key);
        if (node == head) {
            DoublyLinkedListNode<K,V> temp = head.next;
            temp.prev = null;
            head = temp;
        }
        if (node == tail) {//do nothing
            return null;
        } else {
            DoublyLinkedListNode<K,V> prev = node.prev;
            DoublyLinkedListNode<K,V> next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
        }
        return node;
    }

    private void addNodeAtLast(DoublyLinkedListNode<K,V> node) {
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        map.put(node.getKey(), node);
    }

    public K getFirstKey() throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("List is empty");
        }
        K key = head.getKey();
        if (map.containsKey(key)) {
            map.remove(key);
        }
        DoublyLinkedListNode<K,V> temp = head.next;
        head.next = null;
        head = temp;
        return key;
    }

    public void printElements () {
        DoublyLinkedListNode<K,V> curr = head;
        while (curr != null) {
            System.out.print(curr.getKey() + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
