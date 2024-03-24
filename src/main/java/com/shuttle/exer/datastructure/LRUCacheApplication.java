package com.shuttle.exer.datastructure;

import java.util.Random;
import java.util.UUID;

public class LRUCacheApplication {

    private static final String CACHE_KEY_PREFIX = "Person_";

    public static void main(String[] args) {
        LRUCache<String, Person> lruCache = new LRUCache<>(4);
        System.out.println("size: " + lruCache.getSize() + ", freeCapacity: " + lruCache.getFreeCapacity());
        // size: 0, freeCapacity: 4
        addPersonsToCache(lruCache, 2);
        System.out.println("size: " + lruCache.getSize() + ", freeCapacity: " + lruCache.getFreeCapacity());
        // size: 2, freeCapacity: 2
        lruCache.printCacheNodes();
        /**
         * CacheKey: Person_1711262106797, CacheValue: Person{id=1711262106797, name='Person-e4eb', age=16}
         *    <=>
         * CacheKey: Person_1711262106916, CacheValue: Person{id=1711262106916, name='Person-b24b', age=31}
         */
        addPersonsToCache(lruCache, 2);
        System.out.println("size: " + lruCache.getSize() + ", freeCapacity: " + lruCache.getFreeCapacity());
        // size: 4, freeCapacity: 0
        lruCache.printCacheNodes();
        /**
         * CacheKey: Person_1711262106797, CacheValue: Person{id=1711262106797, name='Person-e4eb', age=16}
         *    <=>
         * CacheKey: Person_1711262106916, CacheValue: Person{id=1711262106916, name='Person-b24b', age=31}
         *    <=>
         * CacheKey: Person_1711262107050, CacheValue: Person{id=1711262107050, name='Person-4624', age=32}
         *    <=>
         * CacheKey: Person_1711262106635, CacheValue: Person{id=1711262106635, name='Person-33b1', age=42}
         */
        addPersonsToCache(lruCache, 2);
        lruCache.printCacheNodes();
        /**
         * CacheKey: Person_1711262107050, CacheValue: Person{id=1711262107050, name='Person-4624', age=32}
         *    <=>
         * CacheKey: Person_1711262106635, CacheValue: Person{id=1711262106635, name='Person-33b1', age=42}
         *    <=>
         * CacheKey: Person_1711262107223, CacheValue: Person{id=1711262107223, name='Person-4c21', age=34}
         *    <=>
         * CacheKey: Person_1711262106792, CacheValue: Person{id=1711262106792, name='Person-f540', age=56}
         */
        System.out.println(lruCache.get(lruCache.getFirstKey())); // Person{id=1711262107050, name='Person-4624', age=32}
        lruCache.printCacheNodes();
        /**
         * CacheKey: Person_1711262106635, CacheValue: Person{id=1711262106635, name='Person-33b1', age=42}
         *    <=>
         * CacheKey: Person_1711262107223, CacheValue: Person{id=1711262107223, name='Person-4c21', age=34}
         *    <=>
         * CacheKey: Person_1711262106792, CacheValue: Person{id=1711262106792, name='Person-f540', age=56}
         *    <=>
         * CacheKey: Person_1711262107050, CacheValue: Person{id=1711262107050, name='Person-4624', age=32}
         */
    }

    private static void addPersonsToCache(LRUCache<String, Person> lruCache, int personCount) {
        Random random = new Random();

        for (int i = 0; i < personCount; i++) {
            String name = "Person-" + UUID.randomUUID().toString().substring(0, 4);
            Integer age = 10 + random.nextInt(50);
            Person person = new Person(name, age);
            lruCache.put(getCacheKey(person.getId()), person);
        }
    }

    private static String getCacheKey(Long id) {
        return CACHE_KEY_PREFIX + id;
    }

}
