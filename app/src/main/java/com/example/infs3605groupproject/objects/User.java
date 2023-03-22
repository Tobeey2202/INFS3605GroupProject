package com.example.infs3605groupproject.objects;

public class User {

    private String name;
    private String email;
    private String suburb;
    private String phone;

    public User() {

    }

    public User(String name, String email, String suburb, String phone) {
        this.name = name;
        this.email = email;
        this.suburb = suburb;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}