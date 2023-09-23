/*
 *  Organizing an array as a heap. 
 */

package binaryheaps;

class BinaryHeap {
    private static final int MAX_SIZE = 15;
    private int [] heap;
    private int size;

    public BinaryHeap() {heap=new int[MAX_SIZE]; size=0;}

    // returns the index of the parent node
    public static int parent(int i) {return (i-1)/2;}

    // return the index of the left child 
    public static int leftChild(int i) {return 2*i+1;}

    // return the index of the right child 
    public static int rightChild(int i) {return 2*i+2;}

    // insert the item at the appropriate position
    public void insert(int data) {
        if(size>=MAX_SIZE) {
            System.out.println("The heap is full. Cannot insert"); return;
        }
        // the first time insert at the last position of the array 
        heap[size]=data; size=size+1;
        // and move up until the heap property satisfies
        int i=size-1;
        while(i!=0 && heap[BinaryHeap.parent(i)]<heap[i]) {
            int temp=heap[i]; heap[i]=heap[parent(i)]; heap[parent(i)]=temp;
            i = BinaryHeap.parent(i);
        }
    }

    // prints the heap
    public void printHeap() {
        for(int i=0; i<size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        heap.insert(9); heap.insert(2); heap.insert(8);
        heap.insert(7); heap.insert(10); heap.insert(0);
        heap.insert(1); 
                                  
        /*             10             10 9 8 2 7 0 1      
                     /    \
                    9      8
                   / \    / \
                  2   7  0   1     
        */
        heap.printHeap();
    }   
}
