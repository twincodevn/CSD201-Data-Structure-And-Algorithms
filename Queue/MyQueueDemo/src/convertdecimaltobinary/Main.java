/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertdecimaltobinary;

class Node {
    int info; Node next;
    Node(int x, Node p) {info=x;next=p;}
    Node(int x) {this(x,null);}
}

class MyQueue {
    Node head,tail;
    MyQueue() {head=tail=null;}
    boolean isEmpty() {return(head==null);} 
   
//    void push(int x) {Node q = new Node(x,head); head=q;}
    void enqueue(int x) {
        Node q = new Node(x);
        if(isEmpty()) {head=tail=q;return;}
        tail.next=q;
        tail=q;
    }
//    int pop() {int x=head.info; head=head.next; return(x);}
    int dequeue() {
        int x = head.info;
        head=head.next;
        return(x);
    }
    public void decToBin(double k) {
        System.out.print(k + " in binary system is: ");
        while(k>0) {
            int x = (int)(k*2); 
            enqueue(x); 
            if((k*2)>=1) { 
                k=k*2-1;
            } else { 
                k=k*2;
            }
        }
        System.out.print("0.");
        while(!isEmpty()) System.out.print(dequeue());
        System.out.println();
    }
}

public class Main {
    public static void main(String [] args) {
        MyQueue s = new MyQueue();
        s.decToBin(0.625);
//        System.out.println();
    }
}
