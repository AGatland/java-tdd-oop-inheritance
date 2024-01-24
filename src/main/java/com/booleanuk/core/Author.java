package com.booleanuk.core;

public class Author {
    private String name;
    private String email;
    private String website;

    public Author(String name, String email, String website) {
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getWebsite() {
        return website;
    }
}
