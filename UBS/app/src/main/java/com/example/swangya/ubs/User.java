package com.example.swangya.ubs;

/**
 * Created by Swangya on 12/6/2016.
 */

public class User {
    private int _id;
    private String name;
    private String message;

    public User(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public int get_id() {
        return _id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }
}
