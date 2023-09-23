/*
 *  Java program to demonstrate the creation of queue object using 
 *  the PriorityQueue class.
 */

package queueusingpriorityqueueclass;
  
import java.util.*;
  
class Main {
    public static void main(String args[]) {
        Queue<Integer> pQueue = new PriorityQueue<>();
        pQueue.add(10); pQueue.add(20); pQueue.add(15); 
        pQueue.add(5); pQueue.add(30); pQueue.add(25);
        System.out.print("Priority Queue created: " + pQueue + "\n");
        System.out.print("Size of Priority Queue: " + pQueue.size() + "\n");
        System.out.print("Printing the top element of the Priority Queue: " 
                + pQueue.peek() + "\n");
        System.out.print("Printing the top element and removing it "
                + "from the Priority Queue: " + pQueue.poll() + "\n"); 
        System.out.print("Printing Priority Queue again: " + pQueue + "\n");
        System.out.print("Printing the top element and removing it "
                + "from the Priority Queue: " + pQueue.poll() + "\n"); 
        System.out.print("Printing Priority Queue again: " + pQueue + "\n");
        System.out.print("Printing the top element and removing it "
                + "from the Priority Queue: " + pQueue.poll() + "\n"); 
        System.out.print("Printing Priority Queue again: " + pQueue + "\n");
        System.out.print("Printing the top element and removing it "
                + "from the Priority Queue: " + pQueue.poll() + "\n"); 
        System.out.print("Printing Priority Queue again: " + pQueue + "\n");
        System.out.print("Printing the top element and removing it "
                + "from the Priority Queue: " + pQueue.poll() + "\n"); 
        System.out.print("Printing Priority Queue again: " + pQueue + "\n");
        System.out.print("Printing the top element and removing it "
                + "from the Priority Queue: " + pQueue.poll() + "\n"); 
        System.out.print("Printing Priority Queue again: " + pQueue + "\n");
        System.out.print("Printing the top element and removing it "
                + "from the Priority Queue: " + pQueue.poll() + "\n"); 
        System.out.print("Printing Priority Queue again: " + pQueue + "\n");
    }
}