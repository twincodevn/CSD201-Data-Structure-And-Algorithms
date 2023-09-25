// =========================================================
// Do NOT modify this file 
// This queue is used for breadth-first traversal on graph
// =========================================================

import java.util.*;
public class Queue {
    LinkedList<Integer> t;  
    
    Queue() {
        t = new LinkedList<Integer>();
    }
    
    boolean isEmpty() {
        return(t.isEmpty());
    }
    
    void clear() {
        t.clear();
    }
    
    void enqueue(int x) {
        t.addLast(x);
    }
    
    Integer dequeue() {
        if(isEmpty()) 
            return(null);
        
        return t.removeFirst();
    }
    
    Integer front() {
        if(isEmpty()) 
            return(null);
        
        return t.getFirst();
    }
}

