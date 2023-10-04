/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.lib;

import com.fptuni.csd201.ds.Queue;

/**
 *
 * @author DUNGHUYNH
 */
public class LinkedListQueue implements Queue {

    LinkedList list = new LinkedList();

    @Override
    public void enqueue(int i) {
        list.addToHead(i);
    }

    @Override
    public int dequeue() {
        return list.deleteFromHead();

    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int first() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void traverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
