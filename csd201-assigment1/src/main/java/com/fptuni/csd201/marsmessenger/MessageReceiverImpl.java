/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.marsmessenger;

import com.fptuni.csd201.object.MessagePackage;


/**
 *
 * @author DUNGHUYNH
 */
public class MessageReceiverImpl implements MessageReceiver {

    @Override
    public void receive(MessagePackage pck) {
        
        System.out.println("Index: " + pck.getIndex() + " - " + pck.getContent());
        // STUDENT DEVELOPS CODE HERE
    }

    @Override
    public String getMessage() {
        // STUDENT DEVELOPS CODE HERE
        return "nothing";
    }

    @Override
    public int[] getMissingIndex() {
        // STUDENT DEVELOPS CODE HERE
        return null;
    }
    
}
