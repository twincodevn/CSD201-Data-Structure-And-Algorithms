/*
 *  Implementing a stack using the LinkedList class in Java.
 */

package stackusinglinkedlistclass;

import java.util.*;

class Person {
    String name;int age;
    Person(String xName, int xAge) {name = xName;age=xAge;}
    @Override
    public String toString() {return(name + " " + age);}
}

class MyStack {
    LinkedList<Person> t;
    MyStack() {t = new LinkedList<>();}
    boolean isEmpty() {return(t.isEmpty());}
    void push(Person x) {t.addLast(x);}
    void pushMany(String [] a, int [] b) {
        for(int i=0;i<a.length;i++) push(new Person(a[i],b[i]));
    }
    void popAll() {while(!isEmpty()) System.out.println(pop());}
    Person pop() {if(isEmpty()) return(null); return(t.removeLast());}
}

public class Main {
    public static void main(String[] args) {
        String [] a = {"HOA","LA","CANH","CAY","DAO"};
        int [] b = {25,17,26,19,23};
        MyStack t = new MyStack();
        t.pushMany(a,b);
        t.popAll();
//        System.out.println(); 
    }
}
