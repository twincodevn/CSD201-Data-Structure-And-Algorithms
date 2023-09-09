/*
 *  Array-based Stack
 */

package arraybasedstack;

import java.util.EmptyStackException;

class ArrayStack {
    // Mang Stack 
    Object[] a; 
    // top: index of the top stack , size: size of array 
    int top, size;
    
    public ArrayStack() {};
    
    public ArrayStack(int s) { 
        // khai bao kich thuoc cua mang 
        size = s;
        // tao mang voi kich thuoc cua mang 
        a =  new Object[size];
        // ban dau stack rong thi cho index top = -1 
        top = -1;
    }
    // kiem tra stack rong hay khong 
    public boolean isEmpty() {return(top==-1);}
    // kiem tra stack day hay chua 
    public boolean isFull() {return(top==size-1);}
    
    // xoa tat ca nhung phan tu trong stack 
    public void clear() {top=-1;}
    
    // chen vao stack
    public void push(Object x) { 
        // kiem tra stack day hay chua 
        if(isFull()) return;
        // gan gia tri cho mang stack
        a[++top] = x; 
    }
    
    // lay gia tri tren cung cua stack 
    public Object top() throws EmptyStackException { 
        if(isEmpty()) throw new EmptyStackException();
        // tra ve gia tri tren cung 
        return (a[top]);
    }
    
    // pop() use to remove top element of the stack 
    public void pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        // xoa gia tri 
        a[top]=null; 
        // cap nhat lai top 
        top--;
    }
    
    
    public void printAll() {
        for(int i=0; i<size; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(8);
        for(int i=0; i<6; i++) {as.push(i);} // push(0) -> push(5) 
        System.out.print("Stak created: "); as.printAll();  
        System.out.print("Add 6 to Stack: "); as.push(6); as.printAll();  
        System.out.print("Add 7 to Stack: "); as.push(7); as.printAll(); 
        System.out.print("Add 8 to Stack: "); as.push(8); as.printAll(); 
        System.out.print("Get (remove) " + as.top() + " from Stack: ");
        as.pop(); as.printAll(); 
//        System.out.print("Get (remove) " + as.top() + " from Stack: ");
//        as.pop(); as.printAll(); 
//        System.out.print("Get (remove) " + as.top() + " from Stack: ");
//        as.pop(); as.printAll(); 
//        System.out.print("Add 8 to Stack: "); as.push(8); as.printAll(); 
//        System.out.print("Add 9 to Stack: "); as.push(9); as.printAll(); 
    }
}
