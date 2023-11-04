import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
public class Graph {
    int [][] a; // ma trận kề 
    int n;// số đỉnh 
    char v[];// mảng chứa các đỉnh 
    int deg[];
    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    //Load data from file
    void loadData(int k) {
    RandomAccessFile f;int i,j,x;
        String s;StringTokenizer t;
        a = new int[20][20];
        try{
            f = new RandomAccessFile("data.txt","r");
            for(i = 0; i < k; i++) 
                f.readLine();//ignores the first k-1 lines
            
            s = f.readLine();//just use the data in the k-th line
            s = s.trim();
            n = Integer.parseInt(s);
            for(i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for(j = 0; j < n; j++) { 
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            
            f.close();
        }catch(Exception e) {}
    }

    void dispAdj() {
        int i,j;
        for(i = 0; i < n; i++) {
            System.out.println();
            for(j = 0; j < n; j++)
                System.out.printf("%4d",a[i][j]);
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception { 
        int i,j;
        f.writeBytes("n = "+n+"\r\n");
        for(i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for(j = 0; j < n; j++) 
                f.writeBytes("  " + a[i][j]);
        }
        f.writeBytes("\r\n");
    }

    // bread first traverse from vertex k  
    void breadth(int k, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int i,h;
        boolean [] enqueued = new boolean[n];
        for(i = 0; i < n; i++) 
            enqueued[i] = false;
        
        q.enqueue(k);
        enqueued[k] = true;
        
        while(!q.isEmpty()){
            h = q.dequeue();
            fvisit(h, f); 
            
            for(i = 0; i < n; i++)
                if(!enqueued[i] && a[h][i] > 0) {
                    q.enqueue(i);
                    enqueued[i] = true;
                }
        }
        
        System.out.println();
    }
    

    void depth_rec(boolean [] visited,int k, RandomAccessFile f) throws Exception {
        fvisit(k,f);
        visited[k] = true;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && a[k][i]>0) 
                depth_rec(visited,i,f);
        }
    }
    
    void depth(int k, RandomAccessFile f) throws Exception {
        boolean [] visited = new boolean[20];
        int i;
        for(i = 0; i < n; i++) 
            visited[i] = false;
        depth_rec(visited,k,f);
        for(i = 0; i < n; i++) 
            if(!visited[i]) 
                depth_rec(visited,i,f);
    }

    // This method is used for Question 3.1
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        breadth(2,f);
        f.writeBytes("\r\n");
        /**
         * Question 3.1: Perform breadth-first search on the graph.
         * Starting from the vertex C (which index is 2), ONLY display the vertex right after C up to the next 5 vertices. 
         * Hint: copy breadth(...) to breadth_With_Constraint(...) and modify it appropriately.
         * The output f1() will be written into file 'f1.txt'. 
         * Therefore you should open this file to see/test your code output.
         * Example: With the graph provided in 'data.txt', the content of 'f1.txt' after running this method is 
         *          C  A  F  B  D  H  E  G  I
         *          A  F  B  D  H
         */
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        breadth_With_Constraint(2,f);
 
        
        
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        
        f.writeBytes("\r\n");
        f.close();
    }
void breadth_With_Constraint(int k, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int i,h;
        boolean [] enqueued = new boolean[n];
        for(i = 0; i < n; i++) 
            enqueued[i] = false;
        
        q.enqueue(k);
        enqueued[k] = true;
        int count = 0;
        // count = 1 -> count = 5
        while(!q.isEmpty()){
            h = q.dequeue();
            if(count != 0 && count <= 5 ){
                fvisit(h, f); 
            }
            count++;
            
            for(i = 0; i < n; i++)
                if(!enqueued[i] && a[h][i] > 0) {
                    q.enqueue(i);
                    enqueued[i] = true;
                }
        }
        
        System.out.println();
    }
    void f2() throws Exception {
        loadData(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        f.writeBytes("\r\n");
        /**
         * Question 3.2: Perform depth-first search on the graph.
         * Starting from the fifth vertex (vertex E which index is 4). 
         * Hint: you just call the function 'depth()' appropriately. This function is provided above
         * The output f2() will be written into the file 'f2.txt'. 
         * Therefore you should open this file to see/test your code output.
         * Example: With the graph provided in 'data.txt', the content of 'f2.txt' after running this method is 
         *          E  B  A  C  F  H  I  G  D
         */
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        depth(4,f);
 
        
        
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
  
}
