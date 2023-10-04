/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.ds;

/**
 *
 * @author DUNGHUYNH
 */
public interface Stack {

    boolean isEmpty(); // return true if the stack is empty and false otherwise.

    void clear(); // clear the stack.

    void push(int x); // insert  a node with value  x  at the top of  the stack.

    int pop(); // remove the top element on the stack and return it's value; throw EmptyStackException for empty stack.

    int top(); //  return value of a node at the top of the stack; throw EmptyStackException for empty stack.

    void traverse();
}
