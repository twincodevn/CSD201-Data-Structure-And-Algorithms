/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphtraversals;

import java.util.*;

class MyQueue {
    LinkedList<Integer> t;
    MyQueue() {t=new LinkedList<>();}
    boolean isEmpty() {return(t.isEmpty());}
    void enqueue(int x) {t.add(x);}
    int dequeue() {return(t.removeFirst());}
}

class Graph {
    int [][] a; int n; //adjacency matrix
    char [] v; //all vertices of Graph
    Graph() {v = "ABCDEFGHIJKLMN".toCharArray();} 
    // Set up data
    void setData(int [][] b) {
        n = b.length; 
        a = new int[n][n];
        int i,j;
        for(i=0; i<n; i++)
            for(j=0;j<n;j++) 
                a[i][j] = b[i][j];
    }
    // Print out adjacency matrix
    void dispAdj() {
        int i,j;
        System.out.println("\nThe adjacency matrix:");  
        for(i=0; i<n; i++) {
            System.out.println();
            for(j=0; j<n; j++) 
                System.out.printf("%5d",a[i][j]);
        }
        System.out.println();
    }
    // Print out the vertices found are stored
    void visit(int i) {System.out.print(v[i] + " ");}

    void breadth(int k) {
        MyQueue queue = new MyQueue();
        boolean [] enqueued = new boolean[n];
        int i,j;
        for(i=0; i<n; i++) enqueued[i]=false;
        queue.enqueue(k); enqueued[k] = true; //root (A)
        int r;
        System.out.println("\nBreadth-first traverse from "
                + "the vertex " + v[k] + ":"); //A
        while(!queue.isEmpty()) {
            //remove from queue and print out
            r=queue.dequeue(); visit(r); 
            for(j=0; j<n; j++)
                //if there are un-enqueued vertices and 
                //its adjacent vertices 
                if(!enqueued[j] && a[r][j]>0) {
                    queue.enqueue(j); enqueued[j]=true;
                }
        }
        System.out.println();
    }
    
    void depth(boolean [] visited,int i) {
        visit(i); visited[i]=true;
        for(int j=0; j<n; j++)
        //if there are un-visited vertices and 
        //its adjacent vertices
        if(!visited[j] && a[i][j]>0) depth(visited,j);
    }
    
    void depth(int k) {
        boolean [] visited = new boolean[n];
        int i,j;
        for(i=0; i<n; i++) visited[i]=false;
        System.out.println("\nDepth-first traverse from "
                + "the vertex " + v[k] + ":"); //A
        depth(visited,k);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        int [][] b = {
            {0,1,1,0,1},
            {1,0,1,0,0},
            {1,1,0,1,0},
            {0,0,1,0,0},
            {1,0,0,0,0},
        };
        /*  
            E ----- A ----- B       BFS: A -> B -> C -> E -> D
                    |    /          DFS: A -> B -> C -> D -> E
                    |   /  
                    |  /  
                    | /     
                    |/
            D ------C         
        */
        g.setData(b);
        g.dispAdj();
        g.breadth(0);
        g.depth(0);
        System.out.println();  
    }   
}
