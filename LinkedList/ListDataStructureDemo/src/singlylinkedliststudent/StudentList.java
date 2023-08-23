/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedliststudent;

class Student {
    String name;
    String rollno; 
    int mark;   

    public Student() {
    }

    public Student(String name, String rollno, int mark) {
        this.name = name;
        this.rollno = rollno;
        this.mark = mark;
    }
    
    @Override
    public String toString() {return(name+" "+rollno+" "+mark);} 
}

class Node {
    Student info;
    Node next;
    Node() {}
    Node(Student x, Node p) {info=x;next=p;}
    Node(Student x) {this(x,null);}
}

class MyList {
    Node head, tail;   
    MyList() {head=tail=null;}   
    void clear() {}   
    boolean isEmpty() {return(head==null);}
    
    void addLast(Student x) {
        Node q = new Node(x);
        if(isEmpty()) {head=tail=q;return;}
        tail.next=q;
        tail=q;
    }
    
    void addFirst(Student x) {
        Node q = new Node(x,head);
        head=q;
        if(tail==null) tail=q.next;
    }
  
    void addMany(String [] a, String [] b, int [] c) {
        int n = a.length;
        for(int i=0;i<n;i++) addLast(new Student(a[i],b[i],c[i]));
    }
    
    void traverse() {
        Node p=head;
        while(p!=null) {
            System.out.println(p.info);
            p=p.next;
        }
    }
}

public class StudentList {
    public static void main(String[] args) {
        String [] a = {"Hoa","Hung","Lan","Ngoc","Dung"};
        String [] b = {"01","02","03","04","05"};
        int [] c = {7,8,5,9,6};
        System.out.println("\n- Test addMany():");  
        MyList t = new MyList(); t.addMany(a,b,c);
        t.traverse();
        System.out.println();  
    }    
}
