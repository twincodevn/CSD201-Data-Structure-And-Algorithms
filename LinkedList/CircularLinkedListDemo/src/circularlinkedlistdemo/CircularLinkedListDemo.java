/*
 * Circular Linked List In Java.
 * A circular linked list is a list that has its tail or last node connected 
 * back to the head or the first node.
 * The below program implements a circular linked list wherein we have to 
 * manipulate individual nodes of the linked list.
 */

package circularlinkedlistdemo;

class CircularLinkedList {  
    
    // Node definition for circular linked list  
    public class Node{  
        int data;  
        Node next;  
        public Node() {}
        public Node(int data) {this.data = data;}     
    }    
    
    // Initially head and tail pointers point to null  
    public Node head = null;  
    public Node tail = null;  
    
    // Add new node at the front of the circular linked list   
    public void addBegin(int data){  
        //Create new node  
        Node newNode = new Node(data);  
        //check if list is empty  
        if(head == null) {  
             //head and tail point to same node if list is empty  
            head = newNode;  
            tail = newNode;  
            newNode.next = head;  
        }  
        else {  
            //tail points to new node if list is not empty
            newNode.next = head;  
            //New node becomes new tail.  
            head = newNode; 
            //tail points back to head  
            tail.next = head;  
        }  
    }  
    
    // Add new node at the end of the circular linked list   
    public void addEnd(int data){  
        //Create new node  
        Node newNode = new Node(data);  
        //check if list is empty  
        if(head == null) {  
             //head and tail point to same node if list is empty  
            head = newNode;  
            tail = newNode;  
            newNode.next = head;  
        }  
        else {  
            //tail points to new node if list is not empty
            tail.next = newNode;  
            //New node becomes new tail.  
            tail = newNode;  
            //tail points back to head  
            tail.next = head;  
        }  
    }  
    
    // Deleting a node from the beginning of a list
    public void deleFirst() {
        Node p=head;
        if(p==null) return;
        //if head in not null and next of head is null, delete the head
        if(p.next == null) {
            p = null;
        } else {
            head=p.next;
            tail.next = head;  
        }
    }
    
    // Deleting element from the end of a list
    public void deleLast() {
        Node p=head;
        if(p==null) return;
        //if head in not null and next of head is null, delete the head
        if(p.next == null) {
            p = null;
        } else { //else, traverse to the second last element of the list
            Node temp = new Node();
            temp = p;
            while(temp.next.next != head)
                temp = temp.next; // temp is the second last node 
            //change the next of temp to null and delete the last node
            Node lastNode = temp.next;
            temp.next = head; 
            lastNode = null;
        }
    }
    
    // Display the nodes in circular linked list 
    public void displayList() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("The List is empty");  
        }  
        else {  
            System.out.println("Circular linked list nodes: ");  
             do{  
                //Print each node of the linked list  
                System.out.print(current.data + " ");  
                current = current.next;  
            } while(current != head);  
            System.out.println();  
        }  
    } 
    
}

public class CircularLinkedListDemo {
    
    public static void main(String[] args) {
        // Create a CircularLinkedList object
        CircularLinkedList c_list = new CircularLinkedList();  
        // Add data at the front of the list
        c_list.addBegin(40);  
        c_list.addBegin(50);
        c_list.addBegin(60);
        // Display the nodes in circular linked list 
        c_list.displayList();        
        // Add data at the end of the list  
        c_list.addEnd(30);  
        c_list.addEnd(20);  
        c_list.addEnd(10);  
        // Display the nodes in circular linked list 
        c_list.displayList();             
        // Delete a node
        c_list.deleFirst();
        c_list.deleFirst();
        c_list.displayList(); 
        c_list.deleLast();
        c_list.deleLast();
        c_list.displayList(); 
    } 
    
}
