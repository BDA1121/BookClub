package com.example.thebookclub;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class controllerTest {

    controller check = new controller();

    @Test
    void adduser() {
        user user = new user("testname","testpassword",false);
        user user1 = new user("testname","testpassword",false);
//        check.adduser(user1);
        assertEquals("created",check.adduser(user));
//        assertEquals("Username exists",check.adduser(user));
    }
    @Test
    void addBook() {
        book book = new book("this is us","Test Author","Test Owner","Mint",10,true);
        assertEquals("book successfully added by Test Owner",check.addBook(book));
    }

    @Test
    void changeBookAvailable() {
        book book = new book("this is us","Test Author","Test Owner","Mint",10,true);
        check.addBook(book);
        assertEquals(false,check.changeBookAvailable(book.getBookId()));
    }

    @Test
    void getBooksFromTitle() {
        book book = new book("this is us","Test Author","Test Owner","Mint",10,true);
        ArrayList<book> books = new ArrayList<book>();
        books.add(book);
        check.addBook(book);
        assertEquals(books,check.getBooksFromTitle(book.getTitle()));
    }

    @Test
    void addForum() {
        forum forum = new forum(2,"awesome test","TEst Owner","Test Review");
        check.addForum(forum);
        assertEquals("book successfully added by TEst Owner",check.addForum(forum));
    }


    @Test
    void updateLikes() {
        forum forum = new forum(2,"awesome test","TEst Owner","Test Review");
        check.addForum(forum);
        assertEquals(1,check.updateLikes("4c873e4899a649cbe1d8faf9fe4cb27ed7b9ad005eabfa2ea16b1cd1a39b4e75"));
    }
    @Test
    void updateDislikes() {
        forum forum = new forum(2,"awesome test","TEst Owner","Test Review");
        check.addForum(forum);
        assertEquals(1,check.updateDisLikes("4c873e4899a649cbe1d8faf9fe4cb27ed7b9ad005eabfa2ea16b1cd1a39b4e75"));
    }
}