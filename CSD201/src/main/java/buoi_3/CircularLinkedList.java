/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi_3;

/**
 *
 * @author bravee06
 */
public class CircularLinkedList {
    class Node{
    // information stored 
    int data;
    // pointer 
    Node next;
    
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
    
    
    // chen node truoc danh sach 
    public void addBegin(int data){
        // tao new node 
        Node newNode = new Node(data);
        // th: danh sach rong 
        if(head == null){
            // hai thang tail va head deu tro vao new node 
            // head bang new node 
            head = newNode;
            // tail cung bang new node 
            tail = newNode;
            // tail tro vao head de tao vong 
            tail.next = head;
        }
        // th da co mot so node o trong danh sach 
        else{
            // cap nhat lai moc noi cua tail 
            tail.next = newNode;
            // them moc noi cho new node 
            newNode.next = head;
            // cap nhat lai head cua danh sach 
            head = newNode;
        }
    }
    
    // ham duyet danh sach 
    public void traverse(){
        Node pointer = head;
        // th danh sach rong 
        if(pointer == null){
            System.out.println("The list is empty");
            return;
        } 
        // th da co mot so node
        else{
            do{
                System.out.print(pointer.data + " ");
                pointer = pointer.next;
            }while(pointer != head);
        }
    }
    
    public void addLast(int x ){
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        }else{
            // them moc noi cho node cuoi ( moi them vao ) tro vao head 
            newNode.next = head;
            // cap nhat lai moc noi cho tail
            tail.next = newNode;
            // cap nhat lai tail chinh la node moi
            tail = newNode;
        }
    }
    
    
    // xoa mot node o dau danh sach 
    
    public void deleteFirst(){
        Node q = head;
        // th rong 
        if(q == null) return;
        // th chi co mot node
        else if(q.next == null) {
            q = null;
        }else{
        // th co hon 1 node
        // cap nhat lai thang head 
        head = head.next;
        tail.next = head;
        }
    }
    
    
    public void deleteLast(){
        Node q = head;
        // th rong 
        if(q == null) return;
        // th chi co mot node
        else if(q.next == null) {
            q = null;
        }else{
            // co the su dung (q.next != tail )
            while(q.next.next != head){
                q = q.next;
            }
            q.next = head;
            tail = q;
            
        }
    }
    
    public static void main(String[] args) {
        CircularLinkedList myList = new CircularLinkedList();
        
        
        myList.addBegin(4);
        myList.addBegin(3);
        myList.addBegin(8);
        myList.addBegin(1);
        myList.addBegin(10);
        
        
        
        myList.addLast(11);
        myList.addLast(5);
        
        
        myList.deleteFirst();
        myList.deleteFirst();
        
        myList.deleteLast();
        
        myList.traverse();
        
    }
}
