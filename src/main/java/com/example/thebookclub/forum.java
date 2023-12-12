package com.example.thebookclub;

/**
 * Represents a Forum object in the application.
 */

import java.util.ArrayList;

public class forum {
    private String Id;
    private int type;
    private String title;
    private String content;
    private String ownerID;
    private String timeStamp;
    private ArrayList<String> comments;

    private int likes;
    private int dislikes;
    private int shares;

    public forum(int type,String content, String ownerID, String title){
//        this.Id =Id;
        this.title = title;
        this.ownerID =ownerID;
        this.type = type;
        this.content = content;
        this.likes =0;
        this.dislikes=0;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

}
