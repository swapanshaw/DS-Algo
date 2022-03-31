package com.com.swapan.cache;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

interface Cache<K, V> {
  void put(K key, V value);

  V get(K key);
}

class Node<K, V> {
  K key;
  V Value;

  public Node(K key, V value) {
    this.key = key;
    Value = value;
  }
}

class CacheManager<K, V> implements Cache<K, V> {
  private int size;
  private final Map<K, Node<K, V>> map;
  private final Deque<Node<K, V>> dQueue;

  private CacheManager(int _size) {
    this.size = _size;
    this.map = new HashMap<>();
    this.dQueue = new LinkedList<>();
  }

  static CacheManager newInstance(int _size) {
    return new CacheManager(_size);
  }

  @Override
  public void put(K key, V value) {

    if (key == null || value == null)
      throw new IllegalArgumentException();

    Node<K, V> node = map.get(key);

    if (node != null) {
      dQueue.remove(node);
      dQueue.addFirst(node);
    } else {
      if (map.size() == size) {
        Node<K, V> kvNode = dQueue.removeLast();
        map.remove(kvNode.key);

      }
      node = new Node<>(key, value);
      dQueue.addFirst(node);

    }
    map.put(key, node);
  }

  @Override
  public V get(K key) {

    Node<K, V> node = map.get(key);

    if (node != null) {
      dQueue.remove(node);
      dQueue.addFirst(node);
    }
    return node != null ? node.Value : null;
  }
}


/*class CacheManager<U, T> implements Cache<U, T> {
  int capacity;
  private final Map<U, T> map = new LinkedHashMap<>();

  CacheManager(int _capacity) {
    capacity = _capacity;
  }
  @Override
  public void put(U key, T value) {

    if(key == null || value == null)
      throw new IllegalArgumentException("Not a valid input");


    if(map.size() == capacity -1) {
      LinkedList<U> list = new LinkedList<>(map.keySet());
      //list.descendingIterator()
      //map.remove()
      map.put(key, value);

    }
  }

  @Override
  public T get(U key) {
    return null;
  }
}*/
public class CacheDemo {

  public static void main(String[] args) {
    Cache<Integer, Integer> cache = CacheManager.newInstance(3);


    cache.put(1, 11);
    cache.put(2, 22);
    cache.put(3, 21);
    cache.put(4, 21);
    System.out.println(cache.get(2));

    System.out.println(cache.get(1));

  }
}
