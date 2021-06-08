import cache.CacheImplementation;
import datastructure.DoublyLinkedList;
import policies.EvictionPolicy;
import policies.LRUEvictionPolicy;
import storage.HashMapStorage;
import storage.Storage;

public class Application {
    public static void main(String[] args) {

        Storage<Integer,Integer> storage = new HashMapStorage<>(5);
        DoublyLinkedList<Integer, Integer> doublyLinkedList = new DoublyLinkedList<>();
        EvictionPolicy<Integer, Integer> ep = new LRUEvictionPolicy<>(doublyLinkedList);

        CacheImplementation<Integer, Integer> ci = new CacheImplementation<>(storage, ep);
        ci.put(1,1);
        ci.put(2,2);
        ci.put(3,3);
        ci.put(4,4);
        ci.put(5,5);
        ci.get(2);
        ci.put(6,6);

        ci.printElements();

        ci.get(4);
        ci.put(7,7);

        ci.printElements();
    }
}
