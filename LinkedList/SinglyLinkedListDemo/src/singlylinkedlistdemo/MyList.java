/*
 * Step 2: Build a class to describe a Singly Linked List containing the nodes 
 * in the list and the basic operations (methods) on the list.
 *   - Inserting a new node at the beginning of a list
 *   - Inserting a new node at the end of a list
 *   - Deleting a node from the beginning of a list
 *   - Deleting element from the end of a list
 */

package singlylinkedlistdemo;

public class MyList {
    
    Node head, tail;
    public MyList() {head = tail = null;}
    
    //return true if Mylist is empty otherwise return false
    public boolean isEmpty() {return head == null;} 
    
    //Inserting a new node at the beginning of a list
    public void addFirst(int x) {
        Node p = new Node(x);               
        if(isEmpty()) {head = tail = p;}    
        else {p.next = head; head = p;}     
    }                                       
                                                                                  
    //Inserting a new node at the end of a list
    public void addLast(int x) {
        Node p = new Node(x);
        if(isEmpty()) {head = tail = p;}
        else {tail.next = p; tail = p;}
    }
    
    //Deleting a node from the beginning of a list
    public void deleFirst() {
        Node p=head;
        if(p==null) return;
        //if head in not null and next of head is null, delete the head
        if(p.next == null) {
            p = null;
        } else {
            head=p.next;
        }
    }
    
    //Deleting element from the end of a list
    public void deleLast() {
        Node p=head;
        if(p==null) return;
        //if head in not null and next of head is null, delete the head
        if(p.next == null) {
            p = null;
        } else { //else, traverse to the second last element of the list
            Node temp = new Node();
            temp = p;
            while(temp.next.next != null)
                temp = temp.next; // temp is the second last node 
            //change the next of temp to null and delete the last node
            Node lastNode = temp.next;
            temp.next = null; 
            lastNode = null;
        }
    }

    //Display the nodes in singly linked list 
    public void traversal() {
        Node p = head;
        while(p != null) {
            System.out.print(p.info +"  "); 
            p = p.next;
        }
        System.out.println("");
    }
    
}
