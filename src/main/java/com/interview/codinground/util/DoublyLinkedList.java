package com.interview.codinground.util;

public class DoublyLinkedList<K,V>{
    private final Node<K,V> head, tail;

    public DoublyLinkedList(){

        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }


    public void addToHead(Node<K,V> node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public Node<K,V> removeFromTail(){
        if(tail.prev == head) return null;
        Node<K,V> node = tail.prev;
        removeNode(node);
        return node;
    }

    public void removeNode(Node<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node<K,V> node){
            removeNode(node);
            addToHead(node);
    }

    public Node getHead(){
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }
}
