/*
 *  Array-based Queue .
 */

package arraybasedqueue;

class ArrayQueue {
    // tao mot mang chua cac element cua Queue
    Object[] a; 
    // tao kich thuoc cua mang 
    int size; 
    // là 2 biến trỏ tới head và tail 
    int first, last;
    
    public ArrayQueue() {}
    
    // hàm dựng 
    public ArrayQueue(int size) { 
        this.size = size; 
        
        a = new Object[size];
        // cho hai thằng đầu và cuối có index -1 
        first = last = -1;
    }
    
    // hàm kiểm tra hàng đợi có rỗng 
    public boolean isEmpty() {return(first==-1);}

    // hàm kiểm tra hàng đợi có đầy hay không 
    public boolean isFull() { 
        return((first==0 && last==size-1) || first==last+1);
    }
    
    // hàm thêm vào một ele vào hàng đợi 
    public void enqueue(Object x) { 
        if(isFull()) return; // (1)
        
        if(last==size-1 || last==-1) { // (2) : trường hợp hàng đợi rỗng 
            // cập nhật lại thằng đầu tiên của mảng bằng cái mới thêm vào hàng đợi 
            a[0]=x; 
            // cập nhật lại index của last 
            last=0;
            // trường hợp rông thì cho first = 0 
            if(first==-1) first = 0;
        } else {a[++last] = x;} // (3)
    }
    
    public void dequeue() throws Exception { 
        if(isEmpty()) throw new Exception(); 
        if(first==last)// hàng đợi rỗng 
        {a[first]=null; first=last=-1;}
        else if(first==size-1) // first nằm ở cuối 
        {a[first]=null; first=0;}
        else // nằm ở giữa 
        {a[first]=null; first++;}    
    }
    
    // lấy giả trị của thằng đầu tiên 
    Object front() throws Exception { 
        // 
        if(isEmpty()) throw new Exception();
        return(a[first]);
    }
    
    // in ra hàng đợi 
    public void printAll() {
        
        for(int i=0; i<size; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {  
        // tạo ra hàng đợi có kích thước size = 8 
        ArrayQueue aq = new ArrayQueue(8);
        
        for(int i=0; i<6; i++) {aq.enqueue(i);}
        // 0-1-2-3-4-5
        System.out.print("Queue created : "); aq.printAll();  
        System.out.print("Add 6 to Queue: "); aq.enqueue(6); aq.printAll(); // 0123456 
        System.out.print("Add 7 to Queue: "); aq.enqueue(7); aq.printAll(); // 01234567
        System.out.print("Add 8 to Queue: "); aq.enqueue(8); aq.printAll(); // 012345678
        System.out.print("Get (remove) " + aq.front() + " from Queue: ");
        aq.dequeue(); aq.printAll(); // 1->8
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
