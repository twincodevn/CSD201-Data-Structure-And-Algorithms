/*
 *  Linked implementation of a stack.
 */

package linkedlistbasedstack;

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
}

class MyStack {
    // top element 
    Node head;
    // mac dinh la stack rong 
    MyStack() {head=null;}
    
    // check stack rong 
    boolean isEmpty() {return(head==null);}
    
    // push 
    void push(Person x) {
        // khoi tao tao node 
        Node q = new Node(x,head);
        // kiem tra xem ngan xep rong hay khong 
        if(isEmpty()) {head=q;return;}
        head=q;
    }
    
    void pushMany(String [] a, int [] b) {
        for(int i=0; i<a.length; i++) {
            push(new Person(a[i],b[i]));
        }
    }
    
    // xoa tat car 
    void popAll() {
        while(!isEmpty()) System.out.println(pop());
    }
    
    // xoa node tren cua cua stack va tra ve node tren cung 
    Person pop() {
        if(isEmpty()) return(null);
        // lay ra node tren cung 
        Person x = head.info;
        // gan lai head = head.next 
        head=head.next;
        return(x);
    }
    
    void printAll(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.info + " - ");
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("tuan", 18);
        Person p2 = new Person("dinh", 20);
        MyStack myStack = new MyStack();
        myStack.push(p1);
        myStack.push(p2);
        myStack.printAll();
        String [] a = {"HOA","LA","CANH","CAY","DAO"};
        int [] b = {25,17,26,19,23};
        MyStack t = new MyStack();
        t.pushMany(a,b);
//        t.popAll();
//        System.out.println(); 
    }
}
