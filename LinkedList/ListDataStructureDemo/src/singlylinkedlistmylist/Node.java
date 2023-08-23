/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlistmylist;

public class Node {
    int info; //data of Node
    Node next;
    
    //create a new Node 
    Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    Node(int info) {this(info,null);}
}
