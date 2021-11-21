package com.doraemon.iamfine.userType;

import com.doraemon.iamfine.system.Meeting;

import java.util.ArrayList;



public class User {

    // private members
    private String username, password, phone, email, address, age, gender;
    private ArrayList<Meeting> meetings;

    // public members
    public static ArrayList<User> UserList = new ArrayList<>();

    // constructors
    public User(String username, String password, String phone, String email, String address, String age, String gender) {

        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.meetings = new ArrayList<>();

    }

    public User(String username, String password, String phone, String email, String address, String age, String gender, ArrayList<Meeting> meetings) {

        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.meetings = meetings;

    }

    // methods

        // getters
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getEmail() {
        return this.email;
    }
    public String getAddress() {
        return this.address;
    }
    public String getAge() {
        return this.age;
    }
    public String getGender() {
        return this.gender;
    }
    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

        // setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

        // toString

        // list and JSON methods

        // accompanying methods

}
