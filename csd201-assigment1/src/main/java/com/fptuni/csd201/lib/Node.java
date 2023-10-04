package com.fptuni.csd201.lib;

import com.fptuni.csd201.object.Person;

public class Node {

    int info;
    Node next = null;

    Node() {
    }

    Node(int info, Node nextNode) {
        this.info = info;
        next = nextNode;
    }

    Node(int info) {
        this(info, null);
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
