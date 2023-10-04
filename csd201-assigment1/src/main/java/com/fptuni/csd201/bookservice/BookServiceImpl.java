/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.csd201.bookservice;

import com.fptuni.csd201.object.Book;

/**
 *
 * @author DUNGHUYNH
 */
public class BookServiceImpl implements BookService {

    @Override
    public boolean addBook(Book book) {
        return true;
    }

    @Override
    public void printBook(Book book) {
        
    }

    @Override
    public void showBook(int method) {
        
    }

    @Override
    public Book searchBookbyCode(String bookCode) {
        return null;
    }

    @Override
    public int countBook() {
        return 0;
    }

    @Override
    public boolean removeBook(String bookCode) {
        return true;
    }
    @Override
    public void printAvailableBook() {
    }
    @Override
    public void balancing() {
    }
    @Override
    public Book searchBookbyName(String name) {
         return null;
    }    
}
