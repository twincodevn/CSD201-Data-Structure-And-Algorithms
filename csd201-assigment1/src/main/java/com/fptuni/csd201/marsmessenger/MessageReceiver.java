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
interface MessageReceiver {
    void receive(MessagePackage pck);  
    String getMessage();  // Q1,2
    int[] getMissingIndex(); // Q3

}
