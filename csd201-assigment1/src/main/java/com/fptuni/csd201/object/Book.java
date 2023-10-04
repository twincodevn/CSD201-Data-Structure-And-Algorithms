/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.object;

/**
 *
 * @author DUNGHUYNH
 */
public class Book {
    private String code;
	private String name;
	private int lended;
	private int quantity;
	private double price;
	

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book(String code, String name, int lended, int quantity, double price) {
        this.code = code;
        this.name = name;
        this.lended = lended;
        this.quantity = quantity;
        this.price = price;
    }
	// STUDENTS DEFINE PUBLIC FUNCTIONS
    
}
