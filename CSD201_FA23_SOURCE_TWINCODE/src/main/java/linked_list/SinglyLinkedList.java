/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linked_list;

/**
 *
 * @author bravee06
 */
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
public class SinglyLinkedList {
    // Singly Linked List 
    // Danh sach lien ket don 
    
    Node head;
    Node tail;
    
    public SinglyLinkedList(){
        head = tail = null;
    }
    public boolean isEmpty(){
        // co rong hay khong 
        return head == tail && head == null;
    }
    // 1. ADD 1 NODE VAO LINKED LIST 
    // chèn một node vào cuối danh sách 
    public void addLast(int x){
        // Tao node 
        Node newNode = new Node(x); 
        
        // truong hop danh sach rong thi cho head = tail = newNode 
        if(head == null){
            head = tail = newNode;
        }
        // truong hop da co it nhat mot node 
        else{
            // thêm liên kết 
            tail.next = newNode;
            // thay đổi lại đuôi 
            tail = newNode;
        }
        
        
    }
    // 2. CHÈN VÀO ĐẦU DANH SÁCH 
    public void addFirst(int x){
        // Tao node 
        Node newNode = new Node(x);
        // truong hop danh sach rong thi cho head = tail = newNode 
        if(head == null){
            head = tail = newNode;
        }
        // truong hop da co it nhat mot node 
        else{
            // thêm liên kết cho newNode
            newNode.next = head;
            // thay đổi lại đầu 
            head = newNode;
        }
        
    }
    
    // 3. XOA MOT NODE SAU CUNG 
    public void delete(){
        // th rong 
        if(isEmpty()) return;
        // th chi co 1 node 
        if(head == tail){
            head = tail = null;
            
        }else{
            Node q = head;
            while(q.next != tail){
                q = q.next;
            }
            q.next = null;
            tail = q;
        }
    }
    // SEARCH NODE CO GIA TRI X 
    public Node search(int x){
        Node temp = head;
        do{
            if(temp.data == x) return temp;
            temp = temp.next;
        }while(temp != null);
        
        return null;
    }
    // TINH SO NODE TRONG MOT DANH SACH 
    public int count(){
        if(isEmpty()) return 0;
        Node temp = head;
        int count = 0;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        return count + 1;
    }
    // LAY 1 NODE O VI TRI K 
    public Node get(int k){
        int count = 0;
        Node temp = head;
        do{
           if(count == k) return temp;
           temp = temp.next;
           count++;
        }while(temp != null);
        return null;
    }
    
    // CHEN 1 NODE CO GIA TRI X VAO VI TRI K 
    public void insertNode(int x, int k){
        
        Node newNode = new Node(x);
        Node q = get(k);
        Node temp = q.next;
        q.next = newNode;
        newNode.next = temp;
        
    }
    public void swap(Node a, Node b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    // DAO CHIEU DANH SACH 
    public void reverse(){
        int start = 0;
        int end = count() - 1 ;
        while(start < end){
            Node startNode = get(start);
            Node endNode = get(end);
            swap(startNode,endNode);
            start++;
            end--;
        }
    }
    
    // XOA NODE CHI DINH TRONG DANH SACH 
    public void deleteNode(Node p){
        
        if(head == null || p == null) return;
        Node temp = head;
        while(!temp.equals(p)){
            temp = temp.next;
        }
        Node ke = temp.next.next;
        temp.next = ke;
        
    }
    // . DUYỆT DANH SÁCH ( TRAVERSE ) 
    public void traverse(){
        // tao bien temp 
        Node temp = head;
        // Loop su dung de truy cap node den khi gap null
        while(temp != null){
            System.out.print(temp.data + " ");
            // temp nhay qua node ke ben de doc thong tin 
            temp = temp.next;
        }
    }
    
    // ham main de test 
    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();
        // chèn vào cuối danh sách 1 node 
        myList.addLast(3);
        myList.addLast(6);
        myList.addLast(4);
        myList.addLast(1);
        myList.addFirst(10);
        
        // xoa node cuoi cung 
        myList.delete();
       
        
        // chen node co gia tri 5 vao vi tri 0 
        myList.insertNode(5, 0);
        myList.insertNode(13, 4);
        
        // IN RA MAN HINH DANH SACH LIEN KET 
        
        myList.traverse();
        
        System.out.println("");
        System.out.println("Sau khi dao chieu: ");
        myList.reverse();
        myList.traverse();
        Node temp = myList.head;
        System.out.println(temp);
        myList.deleteNode(temp);
        myList.traverse();
        
        
    }
}
