/*
 *  Java program to demonstrate accessing and removing 
 *  elements from the stack.
 */

package stackclassinjava;

import java.util.*;
 
public class Main {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10); stack.push(15); stack.push(30);
        stack.push(20); stack.push(5);
        // Displaying the Stack
        System.out.println("Initial Stack: " + stack);
        // Fetching the element at the head of the Stack
        System.out.println("The element at the top of the"
                           + " stack is: " + stack.peek());
        // Fetching and removing the element at the head of the Stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        // Displaying the Stack after pop operation
        System.out.println("Stack after pop operation " + stack);
    }
}