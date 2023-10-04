/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra;

import java.io.*;
import java.util.*;

class MyStack {
    LinkedList a;
    MyStack() {a = new LinkedList();}
    boolean isEmpty() {return(a.isEmpty());}
    void push(int x) {a.add(x);}
    int pop() {return((Integer) a.removeLast());}
}

class Graph {
    int [][] a; int n;
    static int INF = 99; // 99 is considered as infinite value
    char [] b;
    
    Graph() {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        b = s1.toCharArray();
    }
    
    void setWeights(String filename) throws IOException {
        int i,j;
        String s="", s1="";
        StringTokenizer t;
        RandomAccessFile f; 
        f = new RandomAccessFile(filename, "r");
        s = f.readLine();
        n = Integer.parseInt(s.trim());
        a = new int[n][n];
        for(i=0;i<n;i++) {
            s = f.readLine();
            t = new StringTokenizer(s);
            for(j=0;j<n;j++) {
                s1 = t.nextToken();
                a[i][j]=Integer.parseInt(s1.trim());
            }
        }
        f.close();
    }
    
    void displayWeights() {
        int i,j;
        System.out.println("\n - The weighted matrix of the graph:");
        System.out.print(" ---------------------------------");
        for(i=0; i<n; i++) {
//            System.out.println("\n");
            System.out.println();
            for(j=0; j<n; j++) 
                if(a[i][j]==INF)
                    System.out.printf(" INF");
                else
                    System.out.printf(" %3d",a[i][j]);
        }
        System.out.println();
    }
    
    void displayStep(int step, boolean [] selected, int [] dist, int [] path,int p, int [] sele, int nSele, boolean [] stopDisplay) {
        int i;
        String S = "";
        for(i=0;i<nSele;i++) S = S + b[sele[i]];
        System.out.printf("\n\n %2d:  %10s",step,S);
        for(i=0;i<n;i++) {
            if(i==p) continue;
            if(dist[i]==INF) {
                System.out.printf("  (%3s,%c)","INF",b[path[i]]);
            } else {
                if(stopDisplay[i]) System.out.printf("         ");
                else System.out.printf("  (%3d,%c)",dist[i],b[path[i]]);
            }
            if(selected[i]) stopDisplay[i]=true;
        }
    } 
    
    // shortest path from vertex p to vertex q
    void dijkstra(boolean [] selected, int [] dist, int [] path,int p, int q, boolean [] stopDisplay) {
        // curr: current vertex, which is to be added to the S set
        int i,j,t,k,curr,step;
        //Khoi tao
        for(i=0;i<n;i++) {
            selected[i]=false;
            stopDisplay[i]=false;
            dist[i]=a[p][i]; // At the first step distance is a direct distance  
            path[i]=p;       // and the vertex before vertex i is the vertex  p
        }
        int [] sele = new int[50];
        int nSele=0; 
        selected[p]=true;
        sele[nSele++] = p;
        curr=p;// add the vertex p the the S set
        System.out.println("\n - Dijkstra algorithm for shortest path from " 
                + b[p] + " to  " + b[q] + ":");
        System.out.println(" ------------------------------------------------"
                + "-------------------------");
        System.out.print("      The S set: ");
        for(i=0;i<n;i++) {
            if(i==p) continue;
            System.out.printf("        %c",b[i]);
        }
        step = 0;
        displayStep(step,selected,dist,path,p,sele,nSele,stopDisplay);
        while(curr!=q) { //Thuc hien vong lap cho den khi gap nut q
            t=INF;k=-1;
            for(i=0;i<n;i++) {
                if(i==p || selected[i]) continue;
                //Tim dinh gan nhat de dua vao S = tap da xet)
                if(dist[i]<t) {t=dist[i];k=i;}
            }
            if(t==INF) {System.out.println("\nKhong co duong di");return;}
            //Dua  dinh k vao tap S da xet
            selected[k]=true;curr=k;
            sele[nSele++] = k;
            //Tinh lai khoang cach
            for(i=0;i<n;i++) {
                if(i==p || selected[i]) continue;
                if(dist[i]>dist[k]+a[k][i]) {
                    dist[i]=dist[k]+a[k][i];
                    path[i]=k;
                }
            }
            step++;
            displayStep(step,selected,dist,path,p,sele,nSele, stopDisplay);
        }
    }
    
    void pathDijkstra(int [] dist, int [] path,int p, int q) {
        MyStack s = new MyStack();
        int i;
        System.out.println("\n\n - The length of shortest path from " 
                + b[p] + " to  " + b[q] + " is: " + dist[q]);
        System.out.print("\n - Path: ");
        i=q;
        s.push(i);
        do {
            i=path[i];
            s.push(i);
        } while(i!=p);
        System.out.print(" ");
        while(!s.isEmpty()) {
            i = s.pop();
            System.out.print(b[i]);
            if(i!=q) System.out.print(" -> ");
        }
    }
    
    void dijkstra(int p, int q) {
        boolean [] selected = new boolean[n];
        boolean [] stopDisplay = new boolean[n];
        int [] dist = new int[n];
        int [] path = new int[n];
        dijkstra(selected, dist,path,p,q,stopDisplay);
        pathDijkstra(dist,path,p,q);
    } 
}

public class Main {
    public static void main(String [] args) {
        String filename;
        filename="matrix.txt";
        /*  
                    2               - The shortest path from A to  F:
                B ----- D           A -> B -> D -> C -> E -> F (15)
                /     /  \
             4 /   3 /    \ 20
           A  /     /      \  F
              \    /       /
            20 \  /       / 5
                \/       /
                C ----- E
                    1
        */
        Graph g =new Graph();
        try {g.setWeights(filename);} catch (IOException e) {}
        g.displayWeights();
        // Duong di ngan nhat tu dinh 1 den dinh 6
        g.dijkstra(0,5); 
        System.out.println("\n ");
    }
}
