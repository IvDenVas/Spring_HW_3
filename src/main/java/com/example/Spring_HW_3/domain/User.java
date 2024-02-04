package com.example.Spring_HW_3.domain;

public class User {
    private String nameUser;
    private int age;
    private String email;

    public String getName() {
        return nameUser;
    }

    public void setName(String name) {
        this.nameUser = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
