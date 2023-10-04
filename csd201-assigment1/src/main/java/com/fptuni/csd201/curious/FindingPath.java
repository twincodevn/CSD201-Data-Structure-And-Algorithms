/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.curious;

/**
 *
 * @author DUNGHUYNH
 */
public class FindingPath {
    
    Curious explorer = null;

    public Curious getExplorer() {
        return explorer;
    }

    public void setExplorer(Curious explorer) {
        this.explorer = explorer;
    }
            
    
    public int run(){
       // STUDENT DEVELOPS CODE HERE
        while (!explorer.isWater()){
            if (!explorer.move()){
                explorer.turnLeft();
            };
        }
        return 1;
        // STUDENT DEVELOPS CODE HERE
    }
  
}
