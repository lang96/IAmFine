package com.doraemon.iamfine.userType;

import com.doraemon.iamfine.system.Meeting;

import java.util.ArrayList;



public class Therapist {

    // private members
    private String username, fullName, password, phone, email, license, experience, gender;
    private ArrayList<Meeting> meetings;

    // public members
    public static ArrayList<Therapist> TherapistList = new ArrayList<>();

    // constructors
    public Therapist(String username, String fullName, String password, String phone, String email, String license, String experience, String gender) {

        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.license = license;
        this.experience = experience;
        this.gender = gender;
        this.meetings = new ArrayList<>();

    }

    public Therapist(String username, String fullName, String password, String phone, String email, String license, String experience, String gender, ArrayList<Meeting> meetings) {

        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.license = license;
        this.experience = experience;
        this.gender = gender;
        this.meetings = meetings;

    }

    // methods

        // getters
    public String getFullName() {
        return fullName;
    }
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
    public String getLicense() {
        return this.license;
    }
    public String getExperience() {
        return this.experience;
    }
    public String getGender() {
        return this.gender;
    }
    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

        // setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
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
    public void setLicense(String license) {
        this.license = license;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

        // toString

        // list and JSON methods
    public static String setNewID() { // ID structure designed for system with a maximum of 999 therapists

        String newID = "";

        if (TherapistList.size() < 9) {
            newID = "TR00" + (TherapistList.size() + 1);
        } else if (TherapistList.size() < 99) {
            newID = "TR0" + (TherapistList.size() + 1);
        } else {
            newID = "TR" + (TherapistList.size() + 1);
        }

        return newID;

    }

        // accompanying methods

}
