/*
 *  Java program for insertion in AVL Tree.
 */

package avltreeinsertion;

class Node {
    int info, height;
    Node left, right;
    Node(int d) {info=d;height=1;}
}

class AVLTree {
    Node root;
    
    // A utility function to get the height of the tree
    int height(Node p) {
        if(p==null) return 0;
        return p.height;
    }
 
    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
 
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        // Perform rotation
        x.right = y;
        y.left = T2;
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        // Perform rotation
        y.left = x;
        x.right = T2;
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        // Return new root
        return y;
    }
 
    // Get balance factor of node p
    int getBalance(Node p) {
        if(p==null) return 0;
        return height(p.left)-height(p.right);
    }
 
    Node insert(Node p, int x) {
        /* 1.  Perform the normal BST insertion */
        if(p==null)
            return (new Node(x));
        if(x<p.info)
            p.left = insert(p.left, x);
        else if (x>p.info)
            p.right = insert(p.right, x);
        else // Duplicate keys not allowed
            return p;
        /* 2. Update height of this ancestor node */
        p.height = 1 + max(height(p.left),
                              height(p.right));
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(p);
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance>1 && x<p.left.info)
            return rightRotate(p);
        // Right Right Case
        if (balance<-1 && x>p.right.info)
            return leftRotate(p);
        // Left Right Case
        if (balance>1 && x>p.left.info) {
            p.left = leftRotate(p.left);
            return rightRotate(p);
        }
        // Right Left Case
        if (balance<-1 && x<p.right.info) {
            p.right = rightRotate(p.right);
            return leftRotate(p);
        }
        /* return the (unchanged) node pointer */
        return p;
    }
    
    void visit(Node p) {
        if(p==null) return;
        System.out.print("  " + p.info);
//        System.out.print("  " + p.info + "("+p.height+")");
    }
    
    void preOrder(Node p) {
        if(p!=null) {
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    void inOrder(Node p) {
        if(p!=null) {
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }
    
    void postOrder(Node p) {
        if(p!=null) {
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }
 
    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        int [] a = {44, 17, 78, 32, 50, 88, 48, 62};
        for(int i=0; i<a.length; i++)
            t.root = t.insert(t.root, a[i]); 
        
        /*        44            - Pre-order     44 17 32 78 50 48 62 88     
               /      \         - In-order      17 32 44 48 50 62 78 88
            17         78       - Post-order    32 17 48 62 50 88 78 44
               \      /  \
              32     50   88
                    /  \
                   48  62
        
        
                  44            - Pre-order     44 17 32 62 50 48 54 78 88 
               /       \        - In-order      17 32 44 48 50 54 62 78 88
            17          62      - Post-order    32 17 48 54 50 88 78 62 44
               \      /   \
               32    50    78
                    /  \    \
                   48  54   88
        */  
        
        System.out.print(" - Pre-order traverse: "); t.preOrder(t.root);
        System.out.print("\n - In-order traverse: "); t.inOrder(t.root);
        System.out.print("\n - Post-order traverse: "); t.postOrder(t.root);
        System.out.print("\n Ater insertion the key 54:"); t.insert(t.root, 54);
        System.out.print("\n - Pre-order traverse: "); t.preOrder(t.root);
        System.out.print("\n - In-order traverse: "); t.inOrder(t.root);
        System.out.print("\n - Post-order traverse: "); t.postOrder(t.root);
        System.out.println();
    }  
}
