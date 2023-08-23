/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singglylinkedlistfile;

import java.io.*;
import java.util.*;

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
    boolean isEmpty() {return(head==null);}
    void clear() {head=tail=null;}
    
    void add(Person x) {
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
    
    void loadFromFile(String fname) throws Exception {
        RandomAccessFile f = new RandomAccessFile(fname,"r");
        StringTokenizer t;
        String s,s1,s2; int k;
        clear();
        while(true) {
            s = f.readLine();
            if(s==null) break;
            if(s.trim().length()<5) continue;
            t = new StringTokenizer(s,"|");
            s1 = t.nextToken();
            s2 = t.nextToken();
            k = Integer.parseInt(s2.trim());
            add(new Person(s1,k));
        }
        f.close();
    }
    
    void saveToFile(String fname) throws Exception {
        File f = new File(fname);
        if(f.exists()) f.delete();
        RandomAccessFile g = new RandomAccessFile(fname,"rw");
        Node p = head;
        while(p!=null) {
            g.writeBytes(p.info.name + " $ " + p.info.age + "\r\n");
            p=p.next;
        }
        g.close();
    }
}

public class LoadFromFile {
    public static void main(String [] args) throws Exception {
        MyList t = new MyList();
        t.loadFromFile("person.txt");
        t.traverse();
        t.saveToFile("person_report.txt");
        System.out.println();  
    }  
}
