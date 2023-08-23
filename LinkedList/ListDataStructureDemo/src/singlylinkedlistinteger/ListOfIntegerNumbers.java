/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlistinteger;

class Node {
    int info;
    Node next;
    
    Node() {}
    
    Node(int x, Node p) { 
        info=x; 
        next=p; 
    }
    
    Node(int x) {this(x, null);}
}

class MyList {
    Node head,tail;
    
    MyList() {head=tail=null;}
    
    boolean isEmpty() {return(head==null);}
    
    void clear() {head=tail=null;}
    
    void addLast(int x) {
        Node q = new Node(x);
        if(isEmpty()) {head=tail=q;return;}
        tail.next=q;
        tail=q;
    }
    
    void addMany(int [] a) {
        for(int i=0; i<a.length; i++) 
        addLast(a[i]);
    }
    
    void visit(Node p) {
        System.out.print(p.info + "  ");
    }
    
    void traverse() {
        Node p = head;
        while(p!=null) {
            visit(p);
            p=p.next;
        }
    }
  
    void sort() {
        Node pi,pj; 
        int t;
        pi=head;
        while(pi!=null) {
            pj=pi.next;
            while(pj!=null) {
                if(pj.info<pi.info) {
                    t=pi.info;
                    pi.info=pj.info;
                    pj.info=t;
                } 
                pj=pj.next;
            }
            pi=pi.next;
        }
    }
}

public class ListOfIntegerNumbers {
    public static void main(String[] args) {
        MyList t = new MyList();
        int [] a = {7,2,9,8,6,3};
        t.addMany(a);
        System.out.println("Before sorting: ");  
        t.traverse();
        System.out.println("\nAfter sorting: ");  
        t.sort();
        t.traverse();
        System.out.println();
    }      
}
