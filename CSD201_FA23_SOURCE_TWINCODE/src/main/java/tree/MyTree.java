/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MyTree {
    class MyQueue {
        LinkedList<Object> head;

        public MyQueue() {
            head = new LinkedList<>();
        }

        public void enqueue(Object obj) {
            head.addLast(obj);
        }

        public boolean isEmpty() {
            return head.isEmpty();
        }

        public Object dequeue() {
            if (isEmpty()) {
                return null;
            } else {
                return head.removeFirst();
            }
        }

        public Object front() {
            if (isEmpty())
                return null;
            return head.getFirst();
        }

        public void clear() {
            head = null;
        }
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

    Node root;

    public MyTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // duyệt node
    public void visit(Node p) {
        if (p == null)
            return;
        System.out.print(p.data + " ");
    }

    // return a Node which key of Node = given key
    // public Node search(Node p,int key){
    // // if(p == null) return null;

    // }
    public Node search(Node p, int key) {
        if (p == null)
            return null;
        if (p.data == key)
            return p;
        else if (p.data > key)
            return search(p.left, key);
        return search(p.right, key);
    }

    // insert a node into tree
    public void insert(int key) {
        Node p = new Node(key);
        Node f = null; // Father node ( node cha )
        Node q = root; // Node con trỏ , chạy đến khi nó gặp null
        while (q != null) {
            if (q.data == key) {
                System.out.println("Key cannot duplicated ! Not insert");
                return;
            }
            f = q;
            if (q.data < key) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        if (f == null) {
            root = p;
        } else if (f.data > key) {
            f.right = p;
        } else {
            f.left = p;
        }
    }

    // duyệt cây theo chiều sâu
    public void preOrder(Node p) {
        if (p == null)
            return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    public void postOrder(Node p) {
        if (p == null)
            return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    // duyệt theo chiều rộng
    public void BFT(Node p) {
        if (p == null)
            return;
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            visit(q);
            if (q.left != null)
                m.enqueue(q.left);
            if (q.right != null)
                m.enqueue(q.right);
        }
    }

    // tính chiều cao của cây
    public int height(Node p) {
        if (p == null)
            return 0;
        else {
            int leftDepth = height(p.left);
            int rightDepth = height(p.right);
            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }

    }

    // xóa node bằng copying
    public void deleteByCopy(int x) {
        Node r = search(root, x);
        if (r == null) {
            System.out.println("Key does not exist, delete fail");
            return;
        }
        // find father of node remove
        Node f = null;
        Node q = root;
        while (q != null) {
            f = q;
            if (q.data > x) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        if (f == null) {
            root = null;
            return;
        }
        // case 1: r does not children
        if (r.left == null && r.right == null) {
            if (f.left == r) {
                f.left = null;
            } else {
                f.right = null;
            }
        }

        // case 2: r has left children
        else if (r.left != null && r.right == null) {
            if (f.right == r) {
                f.right = r.left;
            } else {
                f.left = r.left;
            }
        }
        // case 3: r has right children
        else if (r.left == null && r.right != null) {
            if (f.right == r) {
                f.right = r.right;
            } else {
                f.left = r.right;
            }
        }
        // case 4: r has two children
        else if (r.left != null && r.right != null) {
            // tìm q là node lớn nhất bên phải của node bị xóa
            q = r.left;
            Node father = null;
            while (q.right != null) {
                father = q;
                q = q.right;
            }
            r.data = q.data;
            if (father == null) {
                r.left = q.left;
            } else {
                father.right = q.left;
            }

        }

    }

    // delete by merging
    void deleteMerging(int x) {
        Node r = search(root, x);
        if (r == null) {
            System.out.println("Key does not exist, delete fail");
            return;
        }
        // find father of node remove
        Node f = null;
        Node q = root;
        while (q != null) {
            f = q;
            if (q.data > x) {
                q = q.left;
            } else {
                q = q.right;
            }
        }

        // case 1: r does not children
        if (r.left == null && r.right == null) {
            if (f.left == r) {
                f.left = null;
            } else {
                f.right = null;
            }
        }

        // case 2: r has left children
        else if (r.left != null && r.right == null) {
            if (f.right == r) {
                f.right = r.left;
            } else {
                f.left = r.left;
            }
        }
        // case 3: r has right children
        else if (r.left == null && r.right != null) {
            if (f.right == r) {
                f.right = r.right;
            } else {
                f.left = r.right;
            }
        }
        // case 4 : r has two children
        else if (r.left != null && r.right != null) {
            Node rightMostNode = r.left;
            while (rightMostNode.right != null) {
                rightMostNode = rightMostNode.right;
            }
            rightMostNode.right = r.right;
            if (f == null) {
                root.left = null;
                root.right = null;
            }
            if (f.left == r) {
                f.left = r.left;
            } else {
                f.right = r.right;
            }

        }
    }

    // Balance Tree
    public void balanceTree(ArrayList<Integer> a, int first, int last) {
        Collections.sort(a);
        if (first < last) {
            int mid = (first + last) / 2;
            insert(a.get(mid));
            // đệ quy bên trái
            balanceTree(a, first, mid - 1);
            // đệ quy bên phải
            balanceTree(a, mid + 1, last);
        }

    }

    public Node rotateLeft(Node A) {
        if (A.right == null)
            return A;
        Node B = A.right;
        A.right = B.left;
        B.left = A;
        return B;
    }

    public Node rotateRight(Node A) {
        if (A.left == null)
            return A;
        Node B = A.left;
        A.left = B.right;
        B.right = A;
        return B;
    }

    public Node rotateRightLeft(Node A) {
        if (A.right == null)
            return A;
        Node C = A.right;
        rotateRight(C);
        return rotateLeft(A);
    }

    public Node rotateLeftRight(Node A) {
        if (A.left == null)
            return A;
        Node C = A.left;
        rotateLeft(C);
        return rotateRight(A);
    }

}
