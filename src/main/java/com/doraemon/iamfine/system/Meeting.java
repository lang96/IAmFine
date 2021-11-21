package com.doraemon.iamfine.system;

import java.util.ArrayList;

public class Meeting {

    // private members
    private String meetingID, date, time, therapistID, userID, feedbackID;

    // public members
    public static ArrayList<Meeting> MeetingList = new ArrayList<>();

    public static class Feedback {

        // private members
        private String feedbackID, feedbackComments;

        // public members
        public static ArrayList<Feedback> FeedbackList = new ArrayList<>();

        public Feedback(String id, String comment) {

            this.feedbackID = id;
            this.feedbackComments = comment;

        }

        // methods

            // getters
        public String getFeedbackID() {
            return feedbackID;
        }
        public String getFeedbackComments() {
            return feedbackComments;
        }

            // setters
        public void setFeedbackID(String feedbackID) {
            this.feedbackID = feedbackID;
        }
        public void setFeedbackComments(String feedbackComments) {
            this.feedbackComments = feedbackComments;
        }

            // list and JSON methods

        public static String setNewFeedbackID() { // ID structure designed for a maximum of 9999 feedbacks throughout system

            String newID = "";

            if (FeedbackList.size() < 9) {
                newID = "FB000" + (FeedbackList.size() + 1);
            } else if (FeedbackList.size() < 99) {
                newID = "FB00" + (FeedbackList.size() + 1);
            } else if (FeedbackList.size() < 999) {
                newID = "FB0" + (FeedbackList.size() + 1);
            } else {
                newID = "FB" + (FeedbackList.size() + 1);
            }

            return newID;

        }


    }

    public Meeting(String meetingID, String date, String time, String therapistID, String userID, String feedbackID) {

        this.meetingID = meetingID;
        this.date = date;
        this.time = time;
        this.therapistID = therapistID;
        this.userID = userID;
        this.feedbackID = feedbackID;

    }

    public Meeting(String meetingID, String date, String time, String therapistID, String userID) {

        this.meetingID = meetingID;
        this.date = date;
        this.time = time;
        this.therapistID = therapistID;
        this.userID = userID;

    }

    // methods

        // getters
    public String getMeetingID() {
        return meetingID;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getTherapistID() {
        return therapistID;
    }
    public String getUserID() {
        return userID;
    }
    public String getFeedbackID() {
        return feedbackID;
    }

        // setters
    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setTherapistID(String therapistID) {
        this.therapistID = therapistID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

        // list and JSON methods

    public static String setNewMeetingID() { // ID structure designed for system with a maximum of 9999 meetings

        String newID = "";

        if (MeetingList.size() < 9) {
            newID = "MT000" + (MeetingList.size() + 1);
        } else if (MeetingList.size() < 99) {
            newID = "MT00" + (MeetingList.size() + 1);
        } else if (MeetingList.size() < 999) {
            newID = "MT0" + (MeetingList.size() + 1);
        } else {
            newID = "MT" + (MeetingList.size() + 1);
        }

        return newID;

    }

}
