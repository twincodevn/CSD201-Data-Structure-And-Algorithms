/*
 * Doubly Linked List In Java.
 * The program below shows Java implementation of a doubly-linked list with the 
 * addition and removal of nodes at the end of the list.
 */

package doublylinkedlistdemo;

class DoublyLinkedList {  
    
    // A node class for doubly linked list
    class Node {  
        int item;  
        Node previous;  
        Node next; 
        public Node() {}
        public Node(int item) {this.item = item;}     
    }  
    
    // Initially, heade and tail is set to null
    Node head, tail = null;  
   
    // Add a new node at the beginning of a list
    public void addFirst(int item) {
        //Create a new node  
        Node newNode = new Node(item);   
        //if list is empty, head and tail points to newNode  
        if(head == null) {  
            head = tail = newNode;  
            //head's previous will be null  
            head.previous = null;  
            //tail's next will be null  
            tail.next = null;  
        }  else {  
            newNode.next = head; 
            head = newNode;
            head.previous = null;   
        }  
    }

    // Add a new node at the end of the list  
    public void addLast(int item) {  
        //Create a new node  
        Node newNode = new Node(item);   
        //if list is empty, head and tail points to newNode  
        if(head == null) {  
            head = tail = newNode;  
            //head's previous will be null  
            head.previous = null;  
            //tail's next will be null  
            tail.next = null;  
        }  
        else {  
            //add newNode to the end of list. tail->next set to newNode  
            tail.next = newNode;  
            //newNode->previous set to tail  
            newNode.previous = tail;  
            //newNode becomes new tail  
            tail = newNode;  
            //tail's next point to null  
            tail.next = null;  
        }  
    } 
    
    // Deleting a node from the beginning of a list
    public void deleFirst() {
        Node p = head;
        if(p==null) return;
        //if head in not null and next of head is null, delete the head
        if(p.next==null) {
            p = null;
        } else {
            head = p.next;
            head.previous = null;
        }
    }
    
    // Delete a node from the end of the list 
    public void deleLast() {
        if(this.head != null) {
            //if head in not null and next of head is null, release the head
            if(this.head.next == null) {
                this.head = null;
            } else {
            //Else, traverse to the second last element of the list
                Node temp = new Node();
                temp = this.head;
                while(temp.next.next != null)
                    temp = temp.next;
            //Change the next of the second last node to null and delete the last node
                Node lastNode = temp.next;
                temp.next = null; 
                lastNode = null;
            }
        }
    }

    // Print all the nodes of doubly linked list  
    public void printNodes() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("Doubly linked list is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Print each node and then go to next.  
            System.out.print(current.item + " ");  
            current = current.next;  
        } 
        System.out.println();
    }  
    
}

public class DoublyLinkedListDemo {
    
    public static void main(String[] args) {
        // Create a DoublyLinkedList object
        DoublyLinkedList dl_List = new DoublyLinkedList();  
        // Add nodes to the list  
        dl_List.addFirst(40);  
        dl_List.addFirst(50);  
        dl_List.addFirst(60);
         // Print the nodes of DoublyLinkedList  
        dl_List.printNodes(); 
        dl_List.addLast(30);  
        dl_List.addLast(20);  
        dl_List.addLast(10);    
        // Print the nodes of DoublyLinkedList  
        dl_List.printNodes();       
        // Delete the first node
        dl_List.deleFirst();
        dl_List.deleFirst();
        dl_List.printNodes();  
        // Delete the last node
        dl_List.deleLast();
        dl_List.deleLast();
        dl_List.printNodes();  
    } 
    
}
