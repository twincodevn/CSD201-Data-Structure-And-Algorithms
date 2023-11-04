/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1_pe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Q1 {
    //Change the name of input and output file based on practical paper
    String inputFile = "";
    String outputFile = "";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
    class Node{
        int value;
        Node left,right;
        
        public Node(int item){
            value = item;
            left = right = null;
        }
    }
    
    Node root;
   
    ArrayList<Integer> output = new ArrayList<>();
    
    void insert(int value){
        root = insertRec(root,value);
    }
    
    
    Node insertRec(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(value < root.value){
            root.left = insertRec(root.left,value);
        }else if(value > root.value) {
            root.right = insertRec(root.right,value);
        }
        return root;
    }
    void preOrder(Node node){
        if(node != null){
            if(node.left != null && node.right != null){
                output.add(node.value);
            }
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    void BFS(){
        if(root == null){
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            Node node = nodes.remove();
            output.add(node.value);
            if(node.left != null){
                nodes.add(node.left);
            }
            if(node.right != null){
                nodes.add(node.right);
            }
        }
    }


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    String fi, fo;
    
    /**
     * Set input and output file for automatic rating
     * @param args path of input file and path of output file
     */
    public void setFile (String[] args){
        fi = args.length>=2? args[0]: inputFile;
        fo = args.length>=2? args[1]: outputFile;
    }
    
    /**
     * Reads data from input file
     */
    public void read(){
        try (Scanner sc  = new Scanner(new File(fi))){
    //--END FIXED PART----------------------------
           
            //INPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
            int N = sc.nextInt();
            for(int i = 0; i < N; i++){
                int value = sc.nextInt();
                insert(value);
            }
           


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
            sc.close();
        }catch(FileNotFoundException ex){
            System.out.println("Input Exception # " + ex);
        }
    }
    //--END FIXED PART----------------------------
    
    //ALGORITHM - @STUDENT: ADD YOUROWN METHODS HERE (IF NEED):
    

    
	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    /**
     * Main algorithm
     */
    public void solve(){
    //--END FIXED PART----------------------------

        //ALGORITHM - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
        
        preOrder(root);
	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
    }
    
    /**
     * Write result into output file
     */
    public void printResult(){
	    try{
            FileWriter fw = new FileWriter(fo);
	//--END FIXED PART----------------------------
                
        	//OUTPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
//            fw.write( /*...*/ );
           if(output.isEmpty()){
                fw.write("There is a linked list");
            } else{
               for(int i = 0; i < output.size();i++){
                fw.write(output.get(i) + (i<output.size()-1 ? "," : ""));
            }
           }
            
            


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
            fw.flush();
            fw.close();
        }catch (IOException ex){
            System.out.println("Output Exception # " + ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Q1 q = new Q1();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
	//--END FIXED PART----------------------------    
}
