package com.interview.codinground.util;

import java.util.HashMap;

public class Cache<K,V>{

    private final int capacity;
    private final HashMap<K,Node<K,V>> map;
    private final DoublyLinkedList<K,V> list;

    public Cache(int capacity){
        if(capacity <= 0) throw new IllegalArgumentException("capacity can't be lest than equals to Zero");
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.list = new DoublyLinkedList<>();
    }

    public synchronized  V get(K key){
       if(!map.containsKey(key)) return null;
       Node<K,V> node = map.get(key);
       list.moveToHead(node);
       return node.value;
    }

    public synchronized void put(K key, V value){
        if(map.containsKey(key)){
            Node<K,V> exisitingNode = map.get(key);
            exisitingNode.value = value;
            list.moveToHead(exisitingNode);
        }
        else{
            if(map.size() == capacity){
                Node<K,V> tail = list.removeFromTail();
                map.remove(tail.key);
            }
            Node<K,V> newNode = new Node<>(key,value);
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }

    public void displayCache(){

        Node<K,V> current = list.getHead().next;

        while(current != null && current != list.getTail()){

            System.out.print("Key: " + current.key + " " + "Value: " + current.value + " | ");
            current = current.next;
        }

        System.out.println();
    }


}


/*
capacity = 3

A : 1
B : 2
C : 3

------------------

DLL:  HEAD - C:3 - B:2 - A:1 - TAIL

HashMap: A: NODE(A:1), B: NODE(B:2), C: NODE(C:3)

1. GET(A) -> 1
DLL:  HEAD - A:1 - C:3 - B:2  - TAIL


2. Put(D:4)

HashMap: A: NODE(A:1), B: NODE(B:2), C: NODE(C:3), D: Node(D:4)
DLL:  HEAD - D:4 - A:1 - C:3 - TAIL


Node<K,V>

K key
V value
Node<K,V> prev, next

 */

