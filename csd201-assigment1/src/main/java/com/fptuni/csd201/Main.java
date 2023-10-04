package com.fptuni.csd201;

import com.fptuni.csd201.bookservice.BookServer;
import com.fptuni.csd201.bookservice.BookServiceImpl;
import com.fptuni.csd201.curious.Curious;
import com.fptuni.csd201.curious.FindingPath;
import com.fptuni.csd201.utils.Turtle;
import com.fptuni.csd201.lib.Node;
import com.fptuni.csd201.lib.LinkedList;
import com.fptuni.csd201.marsmessenger.MessageReceiverImpl;
import com.fptuni.csd201.marsmessenger.SpaceShip;
import com.fptuni.csd201.recursion.VonKnockSnowflake;
import com.fptuni.csd201.bookservice.BookService;

public class Main {
    
    public static void testLinkedList(){
        System.out.println("Linked List");

        LinkedList list = new LinkedList();

        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.traverse();
        System.out.println("");

        list.addToTail(4);
        list.addToTail(5);
        list.addToTail(6);
        list.traverse();
        System.out.println("");
        
        list.deleteFromHead();
        list.deleteFromTail();
        list.traverse();
        System.out.println("");

        list.deleteAter(list.search(2));
        list.traverse();
        System.out.println("");

//sai
//        list.dele(3);
//        list.traverse();
//        System.out.println("");

        System.out.print(list.count());
        System.out.println("");
    }
    
    public static void testStack(){
        
    }

    public static void testQueue(){
        
    }
    
    public static void testVonKnockSnowflake(){
        VonKnockSnowflake s = new VonKnockSnowflake();
        s.draw();
        
    }
    
    public static void testMarsMessenger()
    {
        SpaceShip ss = new SpaceShip();

        for (int i = 1; i <= 10; i++) {

            System.out.println("----TEST " + i);
            MessageReceiverImpl msgrec = new MessageReceiverImpl();

            ss.start(i); // Start test case 1-10
            //ss.print();

            while (!ss.isEmpty()) {
                msgrec.receive(ss.next());

            }

            System.out.println(msgrec.getMessage());
        }
        
        for (int i = 11; i <= 15; i++) {

            System.out.println("----TEST " + i);
            MessageReceiverImpl msgrec = new MessageReceiverImpl();

            ss.start(i); // Start test case 10-15
            //ss.print();

            while (!ss.isEmpty()) {
                msgrec.receive(ss.next());

            }
            
            int [] mi = msgrec.getMissingIndex();
            if (mi != null){
                for (int j = 0 ; j < mi.length; j++){
                    System.out.print(mi[j] + " ");
                }
            }
            
            // Q3. PRINT MISSING PACKAGES, PRINT TRUE IF MISSING PACKAGES ARE CORRECT 
            System.out.println();
            System.out.println(ss.setMissingPackages(msgrec.getMissingIndex()));
            
            //ss.print();
            
            //Q4. RESEND THE MISSING PACKAGE AND SHOW COMPLETE MESSAGE
            while (!ss.isEmpty()) {
                msgrec.receive(ss.next());
            }
            
            System.out.println(msgrec.getMessage());
        }
        for (int i = 16; i <= 20; i++) {

            System.out.println("----TEST " + i);
            MessageReceiverImpl msgrec = new MessageReceiverImpl();

            ss.start(i); // Start test case 1-10
            //ss.print();

            while (!ss.isEmpty()) {
                msgrec.receive(ss.next());

            }

            System.out.println(msgrec.getMessage());
        }
    }
    
    public static void testMarsExplorer()
    {
        Curious explorer = new Curious();
        explorer.start(1); // map is the map for testing 1,2,3,4
        explorer.showMap();
        
        FindingPath fp = new FindingPath();
        fp.setExplorer(explorer);
        fp.run();
        
    }
    
    public static void testBookService()
    {
        
        for (int i = 1; i<= 7; i++){
            BookServer server = new BookServer();
            BookService service = new BookServiceImpl();
            
            server.setService(service);
            System.out.println("===TEST " + i);
            server.process(i);
            
        }
    }
    
    public static void main(String[] args) {


        //testBookService();
        //testMarsExplorer();
        testMarsMessenger();
    }
}
