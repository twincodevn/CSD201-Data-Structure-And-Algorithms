/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package balancingatree ;

import java.util.*;

class Node {
    int info;
    Node left,right;
    Node(int x) {info=x;left=right=null;}  
}

class BSTree {
    Node root;
    BSTree() {root=null;}
    boolean isEmpty() {return(root==null);}  
    
    void insert(int x) {
        if(root==null) {root = new Node(x); return;}
        Node f,p; p=root; f=null;
        while(p!=null) {
            if(p.info==x) {
                System.out.println(" The key " + x 
                        + " already exists, no insertion");
                return;
            }
            if(x<p.info) {f=p;p=p.left;}
            else {f=p;p=p.right;}
        }
        if(x<f.info)
            f.left=new Node(x);
        else
            f.right=new Node(x);
    }
    
    void copyDele(int x) {
        if(root==null) {
            System.out.println(" The tree is empty, no deletion");
            return;
        }
        Node f,p; // f will be the father of p
        p=root; f=null;
        while(p!=null) {
            if(p.info==x) break;//Found key x
            if(x<p.info) {f=p;p=p.left;}
            else {f=p;p=p.right;}
        }
        if(p==null) {
            System.out.println(" The key " + x 
                + " does not exist, no deletion");
            return;
        }
        // p is a leaf node
        if(p.left==null && p.right==null) { 
            if(f==null) { // The tree is one node
                root=null;
            } else {
                if(f.left==p) f.left=null; 
                else f.right=null;
            }
            return;
        }
        // p has only left child
        if(p.left!=null && p.right==null) { 
            if(f==null) { // p is a root
                root=p.left;
            } else { // p is aleft child
                if(f.left==p) f.left=p.left;
                else f.right=p.left;
            }
            return;
        }
        // p has only right child
        if(p.left==null && p.right!=null) { 
            if(f==null) { // p is a root
                root=p.right; 
            } else { // p is aleft child
                if(f.left==p) f.left=p.right;
                else f.right=p.right;
            }
            return;
        }
        // p has both left and right children
        if(p.left!=null && p.right!=null) { 
            Node q, qf;
            qf=null;
            q = p.left;
            // Find the right most node on the left sub-tree
            while(q.right!=null) {qf=q; q = q.right;}
            p.info = q.info;
            // q has no right son
            if(qf==null) p.left=q.left;
            else qf.right=q.left;
        }
    }
    
    void visit(Node p) {if(p==null) return; System.out.print("  " + p.info);}
    
    void preOrder(Node p) {
        if(p==null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    
    void inOrder(Node p) {
        if(p==null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    
    void postOrder(Node p) {
        if(p==null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    void addArray(int [] a) {
        for(int i=0; i<a.length; i++)
            insert(a[i]);
    }
    
    void inOrder2(Node p, ArrayList a) {
        if(p==null) return;
        inOrder2(p.left,a);
        a.add(p);
        inOrder2(p.right,a);
    }
    
    void balance(ArrayList a, int lower, int upper) {
        if(lower>upper) return;
        int middle = (lower + upper)/2;
        int x = ((Node) a.get(middle)).info;
        insert(x);
        balance(a,lower, middle-1);
        balance(a,middle+1,upper);
    }
    
    void balance() {
        ArrayList a = new ArrayList();
        inOrder2(root,a); //(1)&(2)
        int n = a.size();
        BSTree g = new BSTree(); //(3)
        g.balance(a,0,n-1); //(4)
        root=g.root;
    }
}

public class Main {
    public static void main(String [] args) {
        BSTree t = new BSTree();
        int [] a = {3,5,1,9,8}; 
        System.out.print("Tree is inserted (3 5 1 9 8):"); t.addArray(a); 
        
        /*         3                             5
                  / \                           / \
                 1   5                         1   8
                      \                         \   \
                       9                        3    9
                      /                      
                     8 
        - Pre-order :   3 1 5 9 8         - Pre-order :   5 1 3 8 9
        - In-order  :   1 3 5 8 9         - In-order  :   1 3 5 8 9
        - Post-order:   1 8 9 5 3         - Post-order:   3 1 9 8 5 
        */
        
        System.out.print("\n - Pre-order traverse   "); t.preOrder(t.root); 
        System.out.print("\n - In-order traverse    "); t.inOrder(t.root);
        System.out.print("\n - Post-order traverse  "); t.postOrder(t.root); 
        System.out.print("\nTree is balanced:"); t.balance();
        System.out.print("\n - Pre-order traverse   "); t.preOrder(t.root); 
        System.out.print("\n - In-order traverse    "); t.inOrder(t.root);
        System.out.print("\n - Post-order traverse  "); t.postOrder(t.root);
        System.out.println("");
    }
}
