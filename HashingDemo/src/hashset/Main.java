/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashset;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Set s = new HashSet();
        String [] a = {"i", "came", "i", "came", "i", "conquered"};
        for(int i=0; i<a.length; i++) {
            if(!s.add(a[i]))
                System.out.println("Duplicate detected : " + a[i]);
        }
        System.out.println(s.size() + " distinct words detected : " + s );
    }
}
