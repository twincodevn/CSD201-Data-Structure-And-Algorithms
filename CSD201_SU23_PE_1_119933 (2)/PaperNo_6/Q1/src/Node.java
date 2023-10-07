// =========================================================
// Do NOT modify this file 
// =========================================================

class Node{
    private Apartment info;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Apartment x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (Apartment x) {
        this(x,null);
    }
    
    public Apartment getInfo() {
        return this.info;
    }
    
    public void setInfo(Apartment info) {
        this.info = info;
    }
 }

