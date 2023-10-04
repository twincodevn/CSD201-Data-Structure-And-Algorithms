/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulercycle;

import java.util.*;

class MyStack {
    LinkedList<Integer> t;
    MyStack() {t = new LinkedList<>();}
    void clear() {t.clear();}
    boolean isEmpty() {return(t.isEmpty());}
    void push(int x) {t.addLast(x);}
    Integer pop() {
        if(isEmpty()) return(null);
        return(t.removeLast());
    }
    Integer top() {
        if(isEmpty()) return(null);
        return(t.getLast());
    }
} 

class EulerCycle {
    int [] e; int m;
    char [] v;
    EulerCycle() {e = new int[50]; m=0; v = "ABCDEFGHIJKLMN".toCharArray();}
    void add(int x) {e[m++] = x;}
    void display() {
        for(int i=0;i<m-1;i++) System.out.print(v[e[i]] + " -> ");
        System.out.println(v[e[m-1]]);
    }
}

class Graph {
    int [][] a; int n;
    char [] v;
    Graph() {n=0; v = "ABCDEFGHIJKLMN".toCharArray();}
    
    void setData(int [][] b) {
        n=b.length;
        a=new int[n][n];
        int i,j;
        for(i=0;i<n;i++)
            for(j=0;j<n;j++) a[i][j]=b[i][j];
    }
    
    void dispAdj() {
        int i,j;
        for(i=0;i<n;i++) {
            System.out.println();
            for(j=0;j<n;j++) System.out.printf("%5d",a[i][j]);
        }
    }
    
    void visit(int i) {System.out.print(v[i] + "  ");}
    
    boolean isDirected() {
        int i,j;
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                if(a[i][j] != a[j][i]) return(true);
        return(false);
    }
    
    int deg(int i) {
        int s,j;
        s=0;
        for(j=0;j<n;j++) s += a[i][j];
        if(a[i][i]>0) s += a[i][i];
        return(s);
    }
    
    boolean isConnected() {
        MyStack s = new MyStack();
        boolean [] p = new boolean[n];
        int i,j,r;
        for(i=0;i<n;i++) p[i]=false;
        s.push(0);p[0]=true;
        while(!s.isEmpty()) {
            r = s.pop();
            for(i=0;i<n;i++)
                if(!p[i] && a[r][i]>0) {s.push(i); p[i]=true;}
        }
        for(i=0;i<n;i++) if(!p[i]) return(false);
        return(true);
    }
    
    boolean isEvenDegree() {
        for(int i=0;i<n;i++)
            if(deg(i) %2 !=0) return(false);
        return(true);
    }  

    boolean hasIsolatedVertex() {
        for(int i=0;i<n;i++) 
            if(deg(i)==0) return(true);
        return(false);
    }
    
    EulerCycle findEulerCycle(int k) {
        if(isDirected() || !isConnected() || 
                !isEvenDegree() || hasIsolatedVertex()) {
            System.out.println(" The conditions for Euler "
                    + "Cycle are not satisfied");
            return(null);
        }
        
        MyStack s = new MyStack();
        int [][] b = new int[n][n];
        int i,j,r;
        for(i=0;i<n;i++)
            for(j=0;j<n;j++) b[i][j]=a[i][j];
        EulerCycle t = new EulerCycle();
        s.push(k);
        
        while(!s.isEmpty()) {
            r = s.top();
            i=0;
            while(i<n && a[r][i]==0) i++;
            if(i==n) { // The vertex r is now isolated
                r = s.pop();
                t.add(r);
            } else {
                s.push(i); a[r][i]--; a[i][r]--;
            }
        }
        setData(b);
        return(t);  
    }
}

public class Main {
    public static void main(String [] args) {
        
    /*          A
             1 /  \ 1
              / 1  \
            B ------ C
            | \    / |
          1 | 1\  /1 | 1
            |   D    | 
            E ------ F                     
                1
    */
        int [][] b = {                  
            {0,1,1,0,0,0},                       
            {1,0,1,1,1,0},                   
            {1,1,0,1,0,1},  
            {0,1,1,0,0,0},  
            {0,1,0,0,0,1},                 
            {0,0,1,0,1,0}              
        };                      
        Graph g = new Graph();
        g.setData(b);
        System.out.println("\n1. Display adjacency matrix:");  
        g.dispAdj();
        System.out.println("\n\n2. Test finding Euler Cycle:");  
        EulerCycle t;
        t = g.findEulerCycle(0);
        t.display();
        System.out.println();  
    }
}
