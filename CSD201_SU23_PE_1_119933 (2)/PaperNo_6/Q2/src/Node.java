// =========================================================
// Do NOT modify this file 
// =========================================================

class Node{
    private Bird info;
    Node left,right;
    //int bal,level;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Bird x, Node leftChild, Node rightChild) {
        this.info = x; // data stored inside the node
        this.left = leftChild; // link to the left child node
        this.right = rightChild; // link to the right child node
    }
    
    //Copy constructor
    Node (Bird x) {
        this(x,null, null);
    }
    
    public Bird getInfo() {
        return this.info;
    }
    
    public void setInfo(Bird inBird) {
        this.info = inBird;
    }
    
    /*public Node getLeft() {
        return this.left;
    }
    
    public Node getRight() {
        return this.right;
    }
    
    public void setLeft(Node left) {
        this.left = left;
    }
    
    public void setRight(Node right) {
        this.right = right;
    }*/
}

