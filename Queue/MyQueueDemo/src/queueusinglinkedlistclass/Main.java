/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueusinglinkedlistclass;

import java.util.*;

class Person {
    String name; int age;
    Person(String xName, int xAge) {name=xName;age=xAge;}
    @Override
    public String toString() {return(name + " " + age);}
}

class MyQueue {
    LinkedList<Person> t;
    MyQueue() {t = new LinkedList<>();}
    boolean isEmpty() {return(t.isEmpty());}
    void enqueue(Person x) {t.addLast(x);}
    void enqueueMany(String [] a, int [] b) {
        for(int i=0; i<a.length; i++) enqueue(new Person(a[i],b[i]));
    }
    void dequeueAll() {while(!isEmpty()) System.out.println(dequeue());}
    Person dequeue() {
        if(isEmpty()) return(null);
        return(t.removeFirst());
//        return(t.removeLast());
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
