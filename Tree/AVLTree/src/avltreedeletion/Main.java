/*
 *  Java program for deletion in AVL Tree.
 */

package avltreedeletion;

class Node {
    int info, height;
    Node left, right;
    Node(int d) {info=d;height=1;}
}
 
class AVLTree {
    Node root;
    
    // A utility function to get height of the tree
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
        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        // Return new root
        return y;
    }
 
    // Get balance factor of node p
    int getBalance(Node p) {
        if(p==null) return 0;
        return height(p.left) - height(p.right);
    }
 
    Node insert(Node p, int x) {
        /* 1. Perform the normal BST rotation */
        if(p==null)
            return (new Node(x));
        if(x<p.info)
            p.left = insert(p.left, x);
        else if (x>p.info)
            p.right = insert(p.right, x);
        else // Equal keys not allowed
            return p;
        /* 2. Update height of this ancestor node */
        p.height = 1 + max(height(p.left),
                            height(p.right));
        /* 3. Get the balance factor of this ancestor
        node to check whether this node became
        Wunbalanced */
        int balance = getBalance(p);
        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if(balance>1 && x<p.left.info)
            return rightRotate(p); 
        // Right Right Case
        if(balance<-1 && x>p.right.info)
            return leftRotate(p);
        // Left Right Case
        if(balance>1 && x>p.left.info) {
            p.left = leftRotate(p.left);
            return rightRotate(p);
        }
        // Right Left Case
        if(balance<-1 && x<p.right.info) {
            p.right = rightRotate(p.right);
            return leftRotate(p);
        }
        /* return the (unchanged) node pointer */
        return p;
    }
 
    /* Given a non-empty binary search tree, return the
    node with minimum key value found in that tree.
    Note that the entire tree does not need to be
    searched. */
    Node minValueNode(Node p) {
        Node current = p;
        /* loop down to find the leftmost leaf */
        while (current.left != null)
        current = current.left;
        return current;
    }
 
    Node deleteNode(Node p, int y) {
        
        // STEP 1: PERFORM STANDARD BST DELETE
        if(p==null)
            return p; 
        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if(y<p.info)
            p.left = deleteNode(p.left, y); 
        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (y>p.info)
            p.right = deleteNode(p.right, y); 
        // if key is same as root's key, then this is the node
        // to be deleted
        else { 
            // node with only one child or no child
            if((p.left==null) || (p.right==null)) {
                Node temp = null;
                if (temp == p.left)
                    temp = p.right;
                else
                    temp = p.left; 
                // No child case
                if (temp == null) {
                    temp = p;
                    p = null;
                }
                else // One child case
                    p = temp; // Copy the contents of
                                // the non-empty child
            } else {
                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(p.right); 
                // Copy the inorder successor's data to this node
                p.info = temp.info; 
                // Delete the inorder successor
                p.right = deleteNode(p.right, temp.info);
            }
        }
        // If the tree had only one node then return
        if(p==null)
            return p;
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        p.height = max(height(p.left), height(p.right)) + 1; 
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(p); 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if(balance>1 && getBalance(p.left)>=0)
            return rightRotate(p); 
        // Left Right Case
        if(balance>1 && getBalance(p.left)<0) {
            p.left = leftRotate(p.left);
            return rightRotate(p);
        } 
        // Right Right Case
        if(balance<-1 && getBalance(p.right)<=0)
            return leftRotate(p); 
        // Right Left Case
        if(balance<-1 && getBalance(p.right)>0) {
            p.right = rightRotate(p.right);
            return leftRotate(p);
        } 
        return p;
    }
 
    void preOrder(Node p) {
        if(p!=null) {
            System.out.print(p.info + " ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }
 
    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        int [] a = {44, 17, 78, 32, 50, 88, 48, 62, 54};
        for(int i=0; i<a.length; i++)
            t.root = t.insert(t.root, a[i]);     
        /* The constructed AVL Tree would be
        
                  44            - Pre-order     44 17 32 62 50 48 54 78 88 
               /       \        
             17        62      
               \      /   \
               32    50    78
                    /  \    \
                   48  54   88
        
        */
        System.out.println("Preorder traversal of tree is : ");
        t.preOrder(t.root); 
        t.root = t.deleteNode(t.root, 32); 
        /* The AVL Tree after deletion of 32
        
                   62           - Pre-order     62 44 17 50 48 54 78 88 
                /      \        
               44      78      
             /    \      \
            17    50    88
                 /  \    
                48  54   
        
        */
        System.out.println("");
        System.out.println("Preorder traversal after deletion of 32 :");
        t.preOrder(t.root);
        System.out.println();
    }
}
