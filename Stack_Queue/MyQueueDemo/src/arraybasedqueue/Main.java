/*
 *  Array-based Queue .
 */

package arraybasedqueue;

class ArrayQueue { 
    Object[] a; int size; 
    int first, last;
    
    public ArrayQueue() {}
    
    public ArrayQueue(int s) { 
        size = s; a = new Object[size];
        first = last = -1;
    }
    
    public boolean isEmpty() {return(first==-1);}

    public boolean isFull() { 
        return((first==0 && last==size-1) || first==last+1);
    }
    
    public void enqueue(Object x) { 
        if(isFull()) return; // (1)
        if(last==size-1 || last==-1) { // (2)
            a[0]=x; last=0;
            if(first==-1) first = 0;
        } else {a[++last] = x;} // (3)
    }
    
    public void dequeue() throws Exception { 
        if(isEmpty()) throw new Exception(); 
        if(first==last) {a[first]=null; first=last=-1;}
        else if(first==size-1) {a[first]=null; first=0;}
        else {a[first]=null; first++;}    
    }
    
    Object front() throws Exception { 
        if(isEmpty()) throw new Exception();
        return(a[first]);
    }
    
    public void printAll() {
        for(int i=0; i<size; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {      
        ArrayQueue aq = new ArrayQueue(8);
        for(int i=0; i<6; i++) {aq.enqueue(i);}
        System.out.print("Queue created : "); aq.printAll();  
        System.out.print("Add 6 to Queue: "); aq.enqueue(6); aq.printAll();  
        System.out.print("Add 7 to Queue: "); aq.enqueue(7); aq.printAll(); 
        System.out.print("Add 8 to Queue: "); aq.enqueue(8); aq.printAll(); 
        System.out.print("Get (remove) " + aq.front() + " from Queue: ");
        aq.dequeue(); aq.printAll(); 
        System.out.print("Get (remove) " + aq.front() + " from Queue: ");
        aq.dequeue(); aq.printAll();
        System.out.print("Get (remove) " + aq.front() + " from Queue: ");
        aq.dequeue(); aq.printAll();
        System.out.print("Add 8 to Queue: "); aq.enqueue(8); aq.printAll(); 
        System.out.print("Add 9 to Queue: "); aq.enqueue(9); aq.printAll();
        System.out.print("Get (remove) " + aq.front() + " from Queue: ");
        aq.dequeue(); aq.printAll(); 
        System.out.print("Get (remove) " + aq.front() + " from Queue: ");
        aq.dequeue(); aq.printAll();
        System.out.print("Add 10 to Queue: "); aq.enqueue(10); aq.printAll();
        System.out.print("Add 11 to Queue: "); aq.enqueue(11); aq.printAll();
        System.out.print("Add 12 to Queue: "); aq.enqueue(12); aq.printAll();
    }
}
