import cache.Cache;
import cache.LRUCache;

public class Main {

    public static void main(String[] args) {

        Cache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // 10

        cache.put(3, 30); // removes key 2

        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 30
    }
}
