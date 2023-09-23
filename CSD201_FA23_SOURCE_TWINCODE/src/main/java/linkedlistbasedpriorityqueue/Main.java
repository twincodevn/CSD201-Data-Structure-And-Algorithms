/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlistbasedpriorityqueue;

class Person {
    String name; int age;
    Person(String xName, int xAge) {name=xName;age=xAge;}
    @Override
    public String toString() {return(name + " " + age);}
}

class Node {
    Person info;
    Node next;
    Node(Person x, Node p) {info=x;next=p;}
    Node(Person x) {this(x,null);}
}

class MyQueue {
    Node head,tail;
    MyQueue() {head=tail=null;}
    boolean isEmpty() {return(head==null);}
    
    void enqueue(Person x) {
        Node q = new Node(x);
        if(isEmpty()) {head=tail=q;return;}
        Node f,p; f=null;p=head;
        while(p!=null && x.age<p.info.age) {f=p;p=p.next;}
        if(p==null) {tail.next=q;tail=q;return;}
        if(f==null) {q.next=head;head=q;return;}
        f.next=q;q.next=p;
    }
    
    void enqueueMany(String [] a, int [] b) {
        for(int i=0; i<a.length; i++) enqueue(new Person(a[i],b[i]));
    }
    
    void dequeueAll() {while(!isEmpty()) System.out.println(dequeue());}
    
    Person dequeue() {
        if(isEmpty()) return(null);
        Person x = head.info;
        head=head.next;
        return(x);
    }
}

public class Main {
    public static void main(String[] args) {
        String [] a = {"HOA","LA","CANH","CAY","DAO"};
        int [] b = {25,17,26,19,23};
        MyQueue t = new MyQueue();
        t.enqueueMany(a,b);
        t.dequeueAll();
//        System.out.println();  
    }
}
