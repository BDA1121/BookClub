package com.example.thebookclub;

/**
 * The Controller class manages the user, book, and forum lists.
 */
import java.util.ArrayList;
public class controller {
//    Initializing lists of users, books and forums
    private ArrayList<user> Users = new ArrayList<user>();
    private ArrayList<book> Books = new ArrayList<book>();
    private ArrayList<forum> Forums = new ArrayList<forum>();

//    My local backend route
    private String route = "https://localhost:4000/";

    /**
     * Adds a new user to the user list in case the user doesn't exist else throws an error.
     *
     * @param User The user object to be added.
     * @return A string indicating the result of the operation.
     */
    public String adduser(user User){
        boolean userFound = false;
        // Iterate through the ArrayList to check if the user with the target ID exists
        for (user user : Users) {
            if (user.getId().equals(User.getId())) {
                userFound = true;
                break; // Exit the loop once a match is found
            }
        }
        // Check the flag to see if the user was found before adding
        if (userFound) {
            return "Username exists";
        } else {
            Users.add(User);
            return "created";
        }
    }
    /**
     * Adds a new book to the book list.
     *
     * @param Book The book object to be added.
     * @return A string indicating the result of the operation.
     */

    public String addBook(book Book){
//        generating Id so that this can referenced whenever we need to find this
        String Id = helpers.generateID(Book.getOwnerId() + Book.getTitle());
        Book.setBookId(Id);
//        adding timestamp as to when was the book uploaded by the owner
        Book.setTimeStamp(helpers.getTimestamp());
//        adding the book to list(later to DB)
        Books.add(Book);
        return "book successfully added by "+Book.getOwnerId();
    }

    /**
     * Changes the availability status of a book.
     *
     * @param Id The ID of the book.
     * @return The updated availability status.
     */

    public boolean changeBookAvailable(String Id){
//the function is updated whenever the book rented or returned
        // Iterate through the ArrayList to check if the book with the target ID exists
        for (book book : Books) {
            if (book.getBookId().equals(Id)) {

                book.setAvailable(!book.isAvailable());
                return book.isAvailable();
            }
        }
        return true;
    }

    /**
     * Retrieves a list of books with the specified title.
     *
     * @param title The title to search for.
     * @return An ArrayList containing books with the given title.
     */

    public ArrayList<book> getBooksFromTitle(String title){
//        the function is for searching purpose - returns list of books with the same title
        ArrayList<book> existingBooks = new ArrayList<>();
        // Iterate through the ArrayList to check if the user with the target ID exists
        for (book book : Books) {
            if (book.getTitle().equals(title)) {
                existingBooks.add(book);
            }
        }

        return existingBooks;
    }

    /**
     * Adds a new forum to the forum list.
     *
     * @param Forum The forum/post object to be added.
     * @return A string indicating the result of the operation.
     */

    public String addForum(forum Forum){
//        similar to adding books
        String Id = helpers.generateID(Forum.getOwnerID() + Forum.getTitle());
        Forum.setId(Id);
        Forum.setTimeStamp(helpers.getTimestamp());
        Forums.add(Forum);
        System.out.println(Forum.getId());
        return "book successfully added by "+Forum.getOwnerID();
    }

    /**
     * Updates the number of likes to a post in forum.
     *
     * @param Id The ID of the book.
     * @return The updated number of likes.
     */

    public int updateLikes(String Id){
//        updates everytime a user likes a forum
//        will add a user checker once login is created
        for (forum forum : Forums) {
            if (forum.getId().equals(Id)) {
                forum.setLikes(forum.getLikes()+1);
                return forum.getLikes();
            }
        }
        return 0;
    }

    /**
     * Updates the number of dislikes to a post in forum.
     *
     * @param Id The ID of the book.
     * @return The updated number of dislikes.
     */
    public int updateDisLikes(String Id){
//        updates everytime a user dislikes a forum
//        will add a user checker once login is created
        for (forum forum : Forums) {
            if (forum.getId().equals(Id)) {
                forum.setDislikes(forum.getDislikes()+1);
                return forum.getDislikes();
            }
        }
        return 0;
    }




}
