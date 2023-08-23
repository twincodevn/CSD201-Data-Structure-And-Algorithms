/*
 * Step 1: Build a class to describe a node in Singly Linked List.
 */

package singlylinkedlistdemo;

public class Node {
    int info; //data of Node
    Node next;    
    //create a new Node 
    public Node() {}
    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }   
    Node(int info) {this(info,null);}
}
