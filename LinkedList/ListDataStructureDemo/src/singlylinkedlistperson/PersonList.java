/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlistperson;

class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {return(name + " " + age);}
}

class Node {
    Person info;
    Node next;
    Node(Person x, Node p) {info=x;next=p;}
    Node(Person x) {this(x,null);}
}

class MyList {
    Node head,tail;
    MyList() {head=tail=null;}
    void clear() {head=tail=null;}
    boolean isEmpty() {return(head==null);}
    
    void add(Person x) {
        Node p = search(x.name);
        if(p!=null) {
            System.out.println("The name " + x.name + " already exists, no addition");
            return;
        }
        Node q = new Node(x);
        if(isEmpty()) {head=tail=q;return;}
        tail.next=q;
        tail=q;
    }
    
    void addMany(String [] a, int [] b) {
        for(int i=0;i<a.length;i++) add(new Person(a[i],b[i]));
    }
    
    void traverse() {
        Node p = head;
        while(p!=null) {
            System.out.println(p.info);
            p=p.next;
        }
    }
    
    Node search(String xName) {
        Node p = head;
        while(p!=null) {
            if(p.info.name.equals(xName)) return(p);
            p=p.next;
        }
        return(p);
    }
    
    void dele(Node q) {
        if(q==null || isEmpty()) return;
        Node f,p; f=null;p=head;
        while(p!=null) {
            if(p==q) break;
            f=p;p=p.next;
        }
        if(p==null) return;
        if(f==null) { //q=head 
            head=head.next;
            if(head==null) tail=null;
            return;
        }
        f.next = p.next;
        if(f.next==null) tail=f; 
    }
    
    void dele(String xName) {
        Node q = search(xName);
        dele(q);
    }
    
    void deleAll(String xName) {}
    void deleFirst() {}
    void deleLast() {}
    void deleBeforeLast() {}
    void dele(int k) {}
    int count() {return(0);}
    
    void sortByName() {
        Node pi,pj; Person t;
        pi=head;
        while(pi!=null) {
            pj=pi.next;
            while(pj!=null) {
                if(pj.info.name.compareTo(pi.info.name)<0) {
                    t=pi.info;pi.info=pj.info;pj.info=t;
                }
                pj=pj.next;
            }
            pi=pi.next;
        }
    }
    
    void sortByAge() {}
    Person [] toArray() {Person [] a = null;return(a);} 
}

public class PersonList {
    public static void main(String [] args) {
        String [] a = {"HOA","LA","CANH","CAY","DAO","LAM"};
        int [] b = {25,17,26,19,23,21};
        MyList t = new MyList();
        t.addMany(a,b);
        t.traverse();
        System.out.println("1. Test dele(Node q)");
        t.dele(t.tail);  
        t.traverse();
        System.out.println("2. Test dele(String xName)");
        t.dele("CANH");  
        t.traverse();
        System.out.println("3. Test sortByname()");
        t.clear();
        t.addMany(a,b);
        t.sortByName();
        t.traverse();
        System.out.println();  
    }
}
