/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package separatechainingusingsinglylinkedlist;

import java.util.*;

class Node {
    int info;
    Node next;
    Node() {}
    Node(int x, Node p) {info=x;next=p;}
}

class MyList {
    Node head,tail;
    MyList() {head=tail=null;}
    void clear() {head=tail=null;}
    boolean isEmpty() {return(head==null);}

    void add(int x) {
        if(isEmpty()) {
            head=tail=new Node(x,null);
        } else {
            Node q =new Node(x,null);
            tail.next=q;
            tail=q;
        }
    }
    
    void traverse() {
        if(isEmpty()) {
            System.out.println(" The list is empty");
            return;
        }
        Node p=head;
        while(p!=null) {
            System.out.print(" " + p.info);
            p=p.next;
        }
        System.out.println();
    }
    
    Node search(int x) {
        Node p = head;
        while(p!=null) {
            if(p.info==x) return(p);
            p=p.next;
        }
        return(null);
    }
    
    void dele(int x) {
        if(isEmpty()) {
            System.out.println("\n The list is empty");
            return;
        }
        if(head.info==x) {
            head=head.next;
            if(head==null) tail=null;
            return;
        }
        Node f,p;f=null; p = head;
        while(p!=null && p.info!=x) {f=p;p=p.next;}
        if(p!=null) {f.next=p.next;}
        else System.out.println(x + " is not found in the list, no deletion");
    }
}

class HashTable {
    MyList [] a;int M; 
    
    HashTable() {
        M = 10;
        a = new MyList[M];
        for(int i=0;i<M;i++) a[i] = new MyList();
    }
    
    boolean isEmpty() {
        boolean empty = true;
        for(int i=0;i<M;i++)
            if(!a[i].isEmpty()) {empty=false;break;}
        return(empty);
    }
    
    void clear() {
        for(int i=0; i<M; i++)
            a[i].head = a[i].tail = null;
    }
  
    void add(int x) {
        int i = x%M;
        a[i].add(x);
    }
    
    void traverse() {
        if(isEmpty()) {
            System.out.println("\n The Hash table is empty");
            return;
        }
        for(int i=0; i<M; i++) {
            System.out.print(" Linked list at " + i + ": ");
            a[i].traverse();
        }
        System.out.println();
    }
    
    Node search(int x) {
        int i = x%M;
        return(a[i].search(x));
    }
    
    void dele(int x) {
        int i = x%M;
        a[i].dele(x);
    }
    
    void addArray(int [] b) {
        int i,n;
        n = b.length;
        for(i=0; i<n; i++)
            add(b[i]);
    }
    
    void addRandom() {
        int i,n,x;
        Scanner s = new Scanner(System.in);
        System.out.print(" Enter n = ");
        n = s.nextInt();
        Random r = new Random();
        clear();
        for(i=0;i<n;i++) {
            x = r.nextInt(100); // Choose value from 0 to 99
            add(x);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int choice, x; Node p;
        int [] b = {5,7,11,3,9,2,6,5,17,23,92,25};
        HashTable t = new HashTable();
        t.addArray(b);
        while(true) {
            System.out.println("\n Choose your option:");
            System.out.println("  1. Create a list randomly");
            System.out.println("  2. Display a list");
            System.out.println("  3. Search");
            System.out.println("  4. Delete");
            System.out.println("  0. Exit\n");
            System.out.print("  Your selection (0 -> 4): ");
            choice = s.nextInt();
            if(choice==0) {
                System.out.println(" Good bye, have a nice day!");
                break;
            }
            switch(choice) {
                case 1: t.addRandom();
                    t.traverse();
                    break;
                case 2: t.traverse();
                    break;
                case 3: System.out.print("\n Enter value to be searched: ");
                    x = s.nextInt();
                    p = t.search(x);
                    if(p!=null)
                        System.out.println(x + " is found in the list");
                    else 
                        System.out.println(x + " is not found in the list");
                    break;
                case 4: System.out.print("\n Enter value to be deleted: ");
                    x = s.nextInt();
                    t.dele(x);
                    t.traverse();
                    break;
                default: System.out.println("**Invalid choice. Try again.**");
            }
        }
    }
}

