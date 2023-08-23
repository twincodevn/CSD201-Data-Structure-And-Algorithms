/*
 *  Step 3: Build a class with main() method to use existing classes 
 *  to complete the program.
 */

package singlylinkedlistdemo;

public class SinglyLinkedListDemo {
    public static void main(String[] args) {  
        MyList mylist = new MyList();
        //Inserting a new node at the beginning of a list.
        mylist.addFirst(40);//40
        mylist.addFirst(50);//50 40 
        mylist.addFirst(60);//60 50 40
        //Display the nodes in singly linked list 
        mylist.traversal();//60 50 40
        //Inserting a new node at the end of a list
        mylist.addLast(30);//60 50 40 30
        mylist.addLast(20);//60 50 40 30 20
        mylist.addLast(10);//60 50 40 30 20 10
        //Display the nodes in singly linked list 
        mylist.traversal();//60 50 40 30 20 10
        //Deleting a node from the beginning of a list
        mylist.deleFirst();//50 40 30 20 10
        mylist.deleFirst();//40 30 20 10
        //Display the nodes in singly linked list 
        mylist.traversal();//40 30 20 10
        //Deleting element from the end of a list
        mylist.deleLast();//40 30 20
        mylist.deleLast();//40 30
        //Display the nodes in singly linked list 
        mylist.traversal();//40 30
    }
}
