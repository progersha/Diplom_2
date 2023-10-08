package org.praktikum.user;

public class User {

    private String email;
    private String password;
    private String name;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
