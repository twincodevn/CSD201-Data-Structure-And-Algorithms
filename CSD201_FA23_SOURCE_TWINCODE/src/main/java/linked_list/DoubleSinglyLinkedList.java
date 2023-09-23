/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linked_list;

/**
 *
 * @author bravee06
 */
public class DoubleSinglyLinkedList {
    class Node{
    // information stored 
    int data;
    // pointer to next Node
    Node next;
    // pointer to previous Node
    Node prev;
    
    // Ham dung 
    public Node(int data1){
        data = data1;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + '}';
    }
    }
    
    // initial head and tail node 
    public Node head = null;
    public Node tail = null;
    
    
    
}
