// =========================================================
// Do NOT modify this file 
// This queue is used for breadth-first search
// =========================================================

import java.util.*;
public class Queue {
    LinkedList<Node> t;
    
    Queue() {
        t=new LinkedList<Node>();
    }
    
    boolean isEmpty() {
        return t.isEmpty();
    }
    
    void enqueue(Node p) {
        t.addLast(p);
    }
   
    Node dequeue() { 
        if(isEmpty()) 
            return(null);
     
        return t.removeFirst();
    }
    
    Node front() { 
        if(isEmpty()) 
            return(null);
        
        return t.getFirst();
    }
}
