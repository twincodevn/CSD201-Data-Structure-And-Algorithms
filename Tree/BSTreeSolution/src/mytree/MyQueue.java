/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mytree;

import java.util.LinkedList;

public class MyQueue {
    LinkedList<Object> head;
    
    public MyQueue() {head = new LinkedList<>();}
    
    public void clear() {head = null;}   
    
    public boolean isEmpty() {return head.isEmpty();}
    
    public void enqueue(Object obj) {head.addLast(obj);}
    
    public Object dequeue() {
        if(isEmpty()) return null;
        else return head.removeFirst();
    }
    
    public Object front() {
        if(isEmpty()) return null;
        else return head.getFirst();
    }  
}
