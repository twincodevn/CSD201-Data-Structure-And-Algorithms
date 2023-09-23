/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

import tree.MyTree.Person;

/**
 *
 * @author bravee06
 */
public class MyTree {
    class Person {
        private int age;
        private String name;

        public Person() {
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" + "age=" + age + ", name=" + name + '}';
        }
        
    }
    class Node {
        Object data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(Object data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString() + "";
        }
        
        
    }
    
    Node root;
    public void insertNode(Node temp, Person key){
        Node newNode = new Node(key,null,null);
        Person newNodePerson = (Person)key;
        if(temp == null){
           temp = newNode;
           System.out.println("");
        }else{
            Node q,f;
            q = temp;
            while(q != null){
                if(q.equals(key)){
                    System.out.println("Data does existed in tree ! Not allowed insert !");
                    return;
                }else{
                    f = q;
                    if(newNodePerson.age > key.age){
                        q = q.left;
                    }else{
                        q = q.right;
                    }
                }
            }
          
                
        }
    }
}
