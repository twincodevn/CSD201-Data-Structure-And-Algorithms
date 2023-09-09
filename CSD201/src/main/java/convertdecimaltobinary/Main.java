/*
 *  Convert decimal integer number to binary number using a stack.
 */

package convertdecimaltobinary;

class Node {
    int info; Node next;
    Node(int x, Node p) {info=x;next=p;}
}

class MyStack {
    Node head;  
    MyStack() {head=null;}   
    boolean isEmpty() {return(head==null);}  
    void push(int x) {Node q = new Node(x,head); head=q;}
    int pop() {int x=head.info; head=head.next; return(x);}
    public void decToBin(int k) {
        System.out.print(k + " in binary system is: ");
        while(k>0) {push(k%2); k=k/2;}
        while(!isEmpty()) System.out.print(pop());
        System.out.println();
    }
}

public class Main {
    public static void main(String [] args) {
        MyStack s = new MyStack();
        s.decToBin(27);
//        System.out.println();
    }
}
