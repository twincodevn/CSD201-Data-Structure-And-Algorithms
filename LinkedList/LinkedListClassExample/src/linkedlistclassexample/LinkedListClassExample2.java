/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistclassexample;

import java.util.*;

class Node { 
    String name; int age;
    Node() {}
    Node(String name1, int age1) {name=name1; age=age1;}
    void set(String name1, int age1) {name=name1; age=age1;}
    @Override
    public String toString() {String s = name+"  "+age; return(s);}
}

public class LinkedListClassExample2 {
        public static void main(String[] args) {
        LinkedList t = new LinkedList();
        Node x; int n,i;
        x = new Node("A01",25); t.add(x);
        x = new Node("A02",23); t.add(x);
        x = new Node("A03",21); t.add(x);
        for(i=0;i<t.size();i++)
            System.out.println(t.get(i));
    }
}
