package org.alecrm.seleniumchallenge.models;

import lombok.Data;

@Data
public class User {

    private String name;
    private String username;
    private String email;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
