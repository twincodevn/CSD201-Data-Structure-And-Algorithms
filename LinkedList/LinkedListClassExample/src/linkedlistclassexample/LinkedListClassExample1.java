/*
 * Methods of the LinkedList class
 * LinkedList class provides APIs that supports various methods to manipulate 
 * the Linked list. We have tabularized the methods in LinkedList API below
 */

package linkedlistclassexample;

import java.util.*; 

public class LinkedListClassExample1 {
    public static void main(String args[])  { 
        // create a linked list 
        LinkedList<String> l_list = new LinkedList<>();         
        // add elements to linkedList using various add methods
        l_list.add("B"); 
        l_list.add("C"); 
        l_list.addLast("G"); 
        l_list.addFirst("A"); 
        l_list.add(3, "D"); 
        l_list.add("E"); 
        l_list.add("F"); 
        // print the linkedList
        System.out.println("Linked list : " + l_list);
         
        // create and initialize an ArrayList
        ArrayList<String> aList = new ArrayList<>();
        aList.add("H");
        aList.add("I");
        // add the ArrayList to linkedList using addAll method
        l_list.addAll(aList);
        // print the linkedList
        System.out.println("Linked list after adding ArrayList contents: " + l_list);
   
        // use various remove methods to remove elements from linkedList
        l_list.remove("B"); 
        l_list.remove(3); 
        l_list.removeFirst(); 
        l_list.removeLast(); 
        //print the altered list
        System.out.println("Linked list after deletion: " + l_list); 
 
        // use contains method to check for an element in the linkedList
        boolean ret_value = l_list.contains("G"); 
        //print the results of contains method
        if(ret_value) 
            System.out.println("List contains the element 'G' "); 
        else
            System.out.println("List doesn't contain the element 'G'"); 
   
        // use size methods to return Number of elements in the linked list 
        int size = l_list.size(); 
        System.out.println("Size of linked list = " + size); 
   
        // get and set elements from linked list 
        Object element = l_list.get(3); 
        System.out.println("Element returned by get() : " + element); 
        l_list.set(3, "J"); 
        System.out.println("Linked list after change : " + l_list); 
         
        // convert linkedList to Array using toArray methods
        String [] list_array = l_list.toArray(new String[l_list.size()]); 
        System.out.println("Array obtained from linked List:" +
            Arrays.toString(list_array));        
    } 
}
