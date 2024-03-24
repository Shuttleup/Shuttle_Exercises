package com.shuttle.exer.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 LRU Cache
 *
 * @param <K> CacheKey
 * @param <V> CacheValue
 */
public class LRUCache<K, V> {

    /**
     * 提供 CacheKey -> Node 的映射表，可以方便 O(1) 时间复杂度获取节点
     */
    private final Map<K, Node<K, V>> keyToNodeMap;

    /**
     * LRU Cache 的实际数据载体
     */
    private final DoubleLinkedList<K, V> linkedList;

    /**
     * Cache 的容量
     */
    private final int capacity;

    /**
     * 使用无参构造器赋予 Cache 的默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Cache 当前使用容量
     */
    private int size;

    /**
     * LRU Cache 无参构造器
     */
    public LRUCache() {
        this.capacity = DEFAULT_CAPACITY;
        this.keyToNodeMap = new HashMap<>();
        this.linkedList = new DoubleLinkedList<>();
        size = 0;
    }

    /**
     * LRU Cache 有参构造器
     *
     * @param initialCapacity 初始容量
     */
    public LRUCache(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("initialCapacity needs to be greater than zero.");
        } else {
            this.capacity = initialCapacity;
        }
        this.keyToNodeMap = new HashMap<>();
        this.linkedList = new DoubleLinkedList<>();
        size = 0;
    }

    /**
     * 获取指定 CacheKey 对应的 Value，不存在返回 null
     *
     * @param key CacheKey
     * @return CacheValue
     */
    public V get(K key) {
        if (!keyToNodeMap.containsKey(key)) {
            return null;
        }
        // 当次访问后放到链表末尾
        moveNodeToTail(key);

        return keyToNodeMap.get(key).val;
    }

    /**
     * 将指定 CacheKey 对应的 node 移到链表尾部
     *
     * @param key CacheKey
     */
    private void moveNodeToTail(K key) {
        Node<K, V> node = keyToNodeMap.get(key);
        linkedList.remove(node);
        linkedList.addLast(node);
    }

    /**
     * 将 <Key, Val> 组成节点放入 LRU Cache 中
     *
     * @param key CacheKey
     * @param val CacheValue
     */
    public void put(K key, V val) {
        // 如果已经存在该 CacheKey，需要更新
        if (keyToNodeMap.containsKey(key)) {
            deleteNodeByKey(key);
            addNode(key, val);
        }
        // 判断容量是否充足
        if (this.capacity <= this.size) {
            removeFirst();
        }
        addNode(key, val);
    }

    /**
     * 删除指定 CacheKey 对应的节点
     *
     * @param key 待删除节点的 CacheKey
     */
    private void deleteNodeByKey(K key) {
        Node<K, V> delNode = keyToNodeMap.get(key);
        linkedList.remove(delNode);
        keyToNodeMap.remove(key);
        size--;
    }

    /**
     * 移除 Cache 链的首位元素
     */
    private void removeFirst() {
        Node<K, V> delNode = linkedList.head.next;
        keyToNodeMap.remove(delNode.key);
        linkedList.remove(delNode);
        size--;
    }

    /**
     * 添加节点到 Cache 链中
     *
     * @param key CacheKey
     * @param val CacheValue
     */
    private void addNode(K key, V val) {
        Node<K, V> newNode = new Node<>(key, val);
        linkedList.addLast(newNode);
        keyToNodeMap.put(key, newNode);
        size++;
    }

    public int getSize() {
        return this.size;
    }

    public int getFreeCapacity() {
        return this.capacity - this.size;
    }

    /**
     * 测试使用
     *
     * @return 返回第一个 CacheKey
     */
    public K getFirstKey() {
        return linkedList.head.next.key;
    }

    public void printCacheNodes() {
        linkedList.prettyPrint();
    }

    /**
     * LRU Cache 实际的数据结构
     *
     * @param <K> Cache Key
     * @param <V> Cache Value
     */
    private static class DoubleLinkedList<K, V> {

        Node<K, V> head;
        Node<K, V> tail;

        DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 添加节点到链表的末尾
         *
         * @param node 待添加的节点
         */
        void addLast(Node<K, V> node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        /**
         * 删除指定节点
         *
         * @param node 待删除的节点
         */
        void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void prettyPrint() {
            Node<K, V> current = head.next;

            while (current != tail) {
                System.out.print("CacheKey: " + current.key + ", CacheValue: " + current.val);
                current = current.next;
                if (current != tail) {
                    System.out.println();
                    System.out.print("   <=>   ");
                }
                System.out.println();
            }
        }

    }

    /**
     * DoubleLinkedList 中实际存储的元素类型
     *
     * @param <K> Node Key
     * @param <V> Node Value
     */
    private static class Node<K, V> {

        K key;
        V val;
        Node<K, V> next;
        Node<K, V> prev;

        Node() {
        }

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

    }

}
