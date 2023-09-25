
public class ListPhone {

    Node head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = null;
    }
    String f0_information(){
        //Assign your RollNumber
        String RollNumber="";
       
        return RollNumber;
    }
    
    void f1_addHead(Phone x) {
     //check if type of x is Op or price >40 do nothing otherwise add x to the head of the list 
  
    }

    void f2_addtail(Phone x) {
     // check if type of x is Op or price >40 do nothing otherwise add x to the tail of the list
      
    }

    void f3_InsertBefore() {
        Phone x = new Phone("Iphone", "X", 0);
        //insert x before first Phone has max price.
         
    }

    void f4_InsertAfter() {
        //insert x after last Phone has max price.
         
      
     }

    void f5_removeOne() {
        //remove first Phone has price <20
         
    }

    void f6_removeAll() {
        //remove all Phones have price <20
        
    }

    void f7_Sort1() {
        //sort list ascending by price
        
          
    }

    void f8_sort2() {
        //sort by price increment from head to last max price
        
         
     }

    void traverse() {
        if (!isEmpty()) {
            Node p = head;
            String s1 = "", s2 = "", s3 = "";
            while (p != null) {
                s1 = p.inf.type;
                s2 = p.inf.model;
                s3 = p.inf.price + "";
                System.out.print("(" + s1 + ", " + s2 + ", " + s3 + ");");
                p = p.next;
            }
            System.out.println("");
        }
    }

}
