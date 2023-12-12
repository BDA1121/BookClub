package com.example.thebookclub;
/**
 * user model and basic getters and setters for each
 */

    public class user {
        private String Id;
        private String password;
        private Boolean isOwner;

        public user(String id, String password, boolean isOwner) {
            this.Id = id;
            this.password = password;
            this.isOwner = isOwner;
        }
    public Boolean getOwner() {
        return isOwner;
    }

    public void setOwner(Boolean owner) {
        isOwner = owner;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
