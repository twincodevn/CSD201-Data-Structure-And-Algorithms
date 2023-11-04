/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        HashMap hMap = new HashMap();
        hMap.put("One", new Integer(1));
        hMap.put("Two", new Integer(2));
        Object obj = hMap.get("One");
        System.out.println(obj);
    }
}

