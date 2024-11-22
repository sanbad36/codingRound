package com.interview.codinground.util;

public class Node<K,V> {
    K key;
    V value;
    Node<K,V> prev, next;

    Node(K key, V value){
        this.key = key;
        this.value = value;
    }
}
