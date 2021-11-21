package com.doraemon.iamfine.data;

import com.doraemon.iamfine.userType.*;
import com.doraemon.iamfine.system.Meeting;
import com.doraemon.iamfine.system.Meeting.Feedback;

import static com.doraemon.iamfine.system.Meeting.Feedback.FeedbackList;
import static com.doraemon.iamfine.system.Meeting.Feedback.setNewFeedbackID;
import static com.doraemon.iamfine.system.Meeting.setNewMeetingID;
import static com.doraemon.iamfine.userType.Therapist.setNewID;
import static com.doraemon.iamfine.userType.User.UserList;
import static com.doraemon.iamfine.userType.Therapist.TherapistList;
import static com.doraemon.iamfine.system.Meeting.MeetingList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class DataOperation {

    public static void initData() {
        initializeMeeting();
        initializeUserTherapist();
        initializeFeedback();
    }

    public static void initializeUserTherapist() {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject userData = (JSONObject) obj;

            JSONArray typeArr = (JSONArray) userData.get("type");
            JSONArray usernameArr = (JSONArray) userData.get("username");
            JSONArray therapistNameArr = (JSONArray) userData.get("therapistName");
            JSONArray passwordArr = (JSONArray) userData.get("password");
            JSONArray phoneArr = (JSONArray) userData.get("phone");
            JSONArray emailArr = (JSONArray) userData.get("email");
            JSONArray addressArr = (JSONArray) userData.get("address");
            JSONArray ageArr = (JSONArray) userData.get("age");
            JSONArray licenseArr = (JSONArray) userData.get("license");
            JSONArray experienceArr = (JSONArray) userData.get("experience");
            JSONArray genderArr = (JSONArray) userData.get("gender");

            if (usernameArr.size() != 0) { // only proceed with array if there are users registered - else start with empty user list

                for (int i = 0; i < usernameArr.size(); i++) {

                    String type = "" + typeArr.get(i);
                    String username = "" + usernameArr.get(i);
                    String password = "" + passwordArr.get(i);
                    String phone = "" + phoneArr.get(i);
                    String email = "" + emailArr.get(i);
                    String gender = "" + genderArr.get(i);

                    // only for user
                    String address = "" + addressArr.get(i);
                    String age = "" + ageArr.get(i);

                    // only for therapist
                    String fullName = "" + therapistNameArr.get(i);
                    String license = "" + licenseArr.get(i);
                    String experience = "" + experienceArr.get(i);

                    switch (type) {

                        case "User":

                            ArrayList<Meeting> meetingsUs = new ArrayList<>();

                            if (!MeetingList.isEmpty()) { // only proceed after MeetingList is initialized and not empty

                                for (int j = 0; j < MeetingList.size(); j++) {
                                    if (MeetingList.get(j).getUserID().equals(username)) {
                                        meetingsUs.add(MeetingList.get(j));
                                    }
                                }

                                if (!meetingsUs.isEmpty()) {
                                    UserList.add(new User(username, password, phone, email, address, age, gender, meetingsUs));
                                    break;
                                } else {
                                    UserList.add(new User(username, password, phone, email, address, age, gender));
                                    break;
                                }

                            } else {
                                UserList.add(new User(username, password, phone, email, address, age, gender));
                                break;
                            }

                        case "Therapist":

                            ArrayList<Meeting> meetingsTh = new ArrayList<>();

                            if (!MeetingList.isEmpty()) { // only proceed after MeetingList is initialized and not empty

                                for (int j = 0; j < MeetingList.size(); j++) {
                                    if (MeetingList.get(j).getTherapistID().equals(username)) {
                                        meetingsTh.add(MeetingList.get(j));
                                    }
                                }

                                if (!meetingsTh.isEmpty()) {
                                    TherapistList.add(new Therapist(username, fullName, password, phone, email, license, experience, gender, meetingsTh));
                                    break;
                                } else {
                                    TherapistList.add(new Therapist(username, fullName, password, phone, email, license, experience, gender));
                                    break;
                                }

                            } else {
                                TherapistList.add(new Therapist(username, fullName, password, phone, email, license, experience, gender));
                                break;
                            }

                        default:
                            continue;

                    }

                }

            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

    }

    public static void initializeMeeting() {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "meetingData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject meetingData = (JSONObject) obj;

            JSONArray meetingIDArr = (JSONArray) meetingData.get("meetingID");
            JSONArray dateArr = (JSONArray) meetingData.get("date");
            JSONArray timeArr = (JSONArray) meetingData.get("time");
            JSONArray therapistIDArr = (JSONArray) meetingData.get("therapistID");
            JSONArray userIDArr = (JSONArray) meetingData.get("userID");
            JSONArray feedbackIDArr = (JSONArray) meetingData.get("feedbackID");

            if (meetingIDArr.size() != 0) { // only proceed with array if there are meetings listed - else start with empty meeting list

                for (int i = 0; i < meetingIDArr.size(); i++) {

                    String meetingID = "" + meetingIDArr.get(i);
                    String date = "" + dateArr.get(i);
                    String time = "" + timeArr.get(i);
                    String therapistID = "" + therapistIDArr.get(i);
                    String userID = "" + userIDArr.get(i);
                    String feedbackID = "" + feedbackIDArr.get(i);

                    MeetingList.add(new Meeting(meetingID, date, time, therapistID, userID, feedbackID));

                }

            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

    }

    public static void initializeFeedback() {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "feedbackData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject feedbackData = (JSONObject) obj;

            JSONArray feedbackIDArr = (JSONArray) feedbackData.get("feedbackID");
            JSONArray feedbackCommentsArr = (JSONArray) feedbackData.get("feedbackComments");

            if (feedbackIDArr.size() != 0) { // only proceed with array if there are feedbacks listed - else start with empty feedback list

                for (int i = 0; i < feedbackIDArr.size(); i++) {

                    String feedbackID = "" + feedbackIDArr.get(i);
                    String feedbackComments = "" + feedbackCommentsArr.get(i);

                    FeedbackList.add(new Feedback(feedbackID, feedbackComments));

                }

            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

    }

    public static void addUser(String username, String password, String phone,
                               String email, String address, String age, String gender) {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject userData = (JSONObject) obj;

            JSONArray typeArr = (JSONArray) userData.get("type");
            JSONArray usernameArr = (JSONArray) userData.get("username");
            JSONArray therapistNameArr = (JSONArray) userData.get("therapistName");
            JSONArray passwordArr = (JSONArray) userData.get("password");
            JSONArray phoneArr = (JSONArray) userData.get("phone");
            JSONArray emailArr = (JSONArray) userData.get("email");
            JSONArray addressArr = (JSONArray) userData.get("address");
            JSONArray ageArr = (JSONArray) userData.get("age");
            JSONArray licenseArr = (JSONArray) userData.get("license");
            JSONArray experienceArr = (JSONArray) userData.get("experience");
            JSONArray genderArr = (JSONArray) userData.get("gender");

            typeArr.add("User");
            usernameArr.add(username);
            therapistNameArr.add("-");
            passwordArr.add(password);
            phoneArr.add(phone);
            emailArr.add(email);
            addressArr.add(address);
            ageArr.add(age);
            licenseArr.add("-");
            experienceArr.add("-");
            genderArr.add(gender);

            userData.put("gender", genderArr);
            userData.put("experience", experienceArr);
            userData.put("license", licenseArr);
            userData.put("age", ageArr);
            userData.put("address", addressArr);
            userData.put("email", emailArr);
            userData.put("phone", phoneArr);
            userData.put("password", passwordArr);
            userData.put("username", usernameArr);
            userData.put("therapistName", therapistNameArr);
            userData.put("type", typeArr);

            UserList.add(new User(username, password, phone, email, address, age, gender));

            try (FileWriter fileWrite = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

                fileWrite.write(userData.toJSONString());
                fileWrite.flush();

            } catch (IOException ef) {
                ef.printStackTrace();
            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

    }

    public static String addTherapist(String fullName, String password, String phone,
                                    String email, String license, String experience, String gender) {

        String username = "";

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject userData = (JSONObject) obj;

            JSONArray typeArr = (JSONArray) userData.get("type");
            JSONArray usernameArr = (JSONArray) userData.get("username");
            JSONArray therapistNameArr = (JSONArray) userData.get("therapistName");
            JSONArray passwordArr = (JSONArray) userData.get("password");
            JSONArray phoneArr = (JSONArray) userData.get("phone");
            JSONArray emailArr = (JSONArray) userData.get("email");
            JSONArray addressArr = (JSONArray) userData.get("address");
            JSONArray ageArr = (JSONArray) userData.get("age");
            JSONArray licenseArr = (JSONArray) userData.get("license");
            JSONArray experienceArr = (JSONArray) userData.get("experience");
            JSONArray genderArr = (JSONArray) userData.get("gender");

            // generating meeting ID based on existing number of meetings
            username = setNewID();

            typeArr.add("Therapist");
            usernameArr.add(username);
            therapistNameArr.add(fullName);
            passwordArr.add(password);
            phoneArr.add(phone);
            emailArr.add(email);
            addressArr.add("-");
            ageArr.add("-");
            licenseArr.add(license);
            experienceArr.add(experience);
            genderArr.add(gender);

            userData.put("gender", genderArr);
            userData.put("experience", experienceArr);
            userData.put("license", licenseArr);
            userData.put("age", ageArr);
            userData.put("address", addressArr);
            userData.put("email", emailArr);
            userData.put("phone", phoneArr);
            userData.put("password", passwordArr);
            userData.put("username", usernameArr);
            userData.put("therapistName", therapistNameArr);
            userData.put("type", typeArr);

            TherapistList.add(new Therapist(username, fullName, password, phone, email, license, experience, gender));

            try (FileWriter fileWrite = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

                fileWrite.write(userData.toJSONString());
                fileWrite.flush();

            } catch (IOException ef) {
                ef.printStackTrace();
            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

        return username;

    }

    public static void addMeeting(String date, String time, String therapistID, String userID) {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "meetingData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject meetingData = (JSONObject) obj;

            JSONArray meetingIDArr = (JSONArray) meetingData.get("meetingID");
            JSONArray dateArr = (JSONArray) meetingData.get("date");
            JSONArray timeArr = (JSONArray) meetingData.get("time");
            JSONArray therapistIDArr = (JSONArray) meetingData.get("therapistID");
            JSONArray userIDArr = (JSONArray) meetingData.get("userID");
            JSONArray feedbackIDArr = (JSONArray) meetingData.get("feedbackID");

            // generating meeting ID based on existing number of meetings
            String meetingID = setNewMeetingID();

            meetingIDArr.add(meetingID);
            dateArr.add(date);
            timeArr.add(time);
            therapistIDArr.add(therapistID);
            userIDArr.add(userID);
            feedbackIDArr.add("");

            meetingData.put("feedbackID", feedbackIDArr);
            meetingData.put("userID", userIDArr);
            meetingData.put("therapistID", therapistIDArr);
            meetingData.put("time", timeArr);
            meetingData.put("date", dateArr);
            meetingData.put("meetingID", meetingIDArr);

            MeetingList.add(new Meeting(meetingID, date, time, therapistID, userID));

            try (FileWriter fileWrite = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "meetingData.json")) {

                fileWrite.write(meetingData.toJSONString());
                fileWrite.flush();

            } catch (IOException ef) {
                ef.printStackTrace();
            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

    }

    public static void addFeedback(String comments) {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "feedbackData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject feedbackData = (JSONObject) obj;

            JSONArray feedbackIDArr = (JSONArray) feedbackData.get("feedbackID");
            JSONArray feedbackCommentsArr = (JSONArray) feedbackData.get("feedbackComments");

            // generating meeting ID based on existing number of meetings
            String feedbackID = setNewFeedbackID();

            feedbackIDArr.add(feedbackID);
            feedbackCommentsArr.add(comments);

            feedbackData.put("feedbackID", feedbackIDArr);
            feedbackData.put("feedbackComments", feedbackCommentsArr);

            FeedbackList.add(new Feedback(feedbackID, comments));

            try (FileWriter fileWrite = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "feedbackData.json")) {

                fileWrite.write(feedbackData.toJSONString());
                fileWrite.flush();

            } catch (IOException ef) {
                ef.printStackTrace();
            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

    }

    public static void editUser(String username, String password,
                                String phone, String email, String address,
                                String age, String gender) {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject userData = (JSONObject) obj;

            JSONArray usernameArr = (JSONArray) userData.get("username");
            JSONArray passwordArr = (JSONArray) userData.get("password");
            JSONArray phoneArr = (JSONArray) userData.get("phone");
            JSONArray emailArr = (JSONArray) userData.get("email");
            JSONArray addressArr = (JSONArray) userData.get("address");
            JSONArray ageArr = (JSONArray) userData.get("age");
            JSONArray genderArr = (JSONArray) userData.get("gender");

            String idCompare = "";
            int jsonUpdateIndex = 0;
            int listUpdateIndex = 0;

            if (usernameArr.size() != 0) { // only proceed if list is not empty

                for (int i = 0; i < usernameArr.size(); i++) {

                    idCompare = "" + usernameArr.get(i);
                    if (idCompare.equals(username)) {
                        jsonUpdateIndex = i;
                        break;
                    }

                }

                for (int j = 0; j < UserList.size(); j++) {

                    if (idCompare.equals(UserList.get(j).getUsername())) {
                        listUpdateIndex = j;
                        break;
                    }

                }

                UserList.get(listUpdateIndex).setPassword(password);
                UserList.get(listUpdateIndex).setPhone(phone);
                UserList.get(listUpdateIndex).setEmail(email);
                UserList.get(listUpdateIndex).setAddress(address);
                UserList.get(listUpdateIndex).setAge(age);
                UserList.get(listUpdateIndex).setGender(gender);

                passwordArr.set(jsonUpdateIndex, password);
                phoneArr.set(jsonUpdateIndex, phone);
                emailArr.set(jsonUpdateIndex, email);
                addressArr.set(jsonUpdateIndex, address);
                ageArr.set(jsonUpdateIndex, age);
                genderArr.set(jsonUpdateIndex, gender);

                userData.put("gender", genderArr);
                userData.put("age", ageArr);
                userData.put("address", addressArr);
                userData.put("email", emailArr);
                userData.put("phone", phoneArr);
                userData.put("password", passwordArr);

                try (FileWriter fileWrite = new FileWriter(System.getProperty("user.dir") +
                        "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

                    fileWrite.write(userData.toJSONString());
                    fileWrite.flush();

                } catch (IOException ef) {
                    ef.printStackTrace();
                }

            } else { // cancel remove operation and notify user

            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

    }

    public static void editTherapist(String username, String password,
                                     String phone, String email, String license,
                                     String experience, String gender) {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") +
                "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

            Object obj = jsonParser.parse(reader);
            JSONObject userData = (JSONObject) obj;

            JSONArray usernameArr = (JSONArray) userData.get("username");
            JSONArray passwordArr = (JSONArray) userData.get("password");
            JSONArray phoneArr = (JSONArray) userData.get("phone");
            JSONArray emailArr = (JSONArray) userData.get("email");
            JSONArray licenseArr = (JSONArray) userData.get("license");
            JSONArray experienceArr = (JSONArray) userData.get("experience");
            JSONArray genderArr = (JSONArray) userData.get("gender");

            String idCompare = "";
            int jsonUpdateIndex = 0;
            int listUpdateIndex = 0;

            if (usernameArr.size() != 0) { // only proceed if list is not empty

                for (int i = 0; i < usernameArr.size(); i++) {

                    idCompare = "" + usernameArr.get(i);
                    if (idCompare.equals(username)) {
                        jsonUpdateIndex = i;
                        break;
                    }

                }

                for (int j = 0; j < TherapistList.size(); j++) {

                    if (idCompare.equals(TherapistList.get(j).getUsername())) {
                        listUpdateIndex = j;
                        break;
                    }

                }

                TherapistList.get(listUpdateIndex).setPassword(password);
                TherapistList.get(listUpdateIndex).setPhone(phone);
                TherapistList.get(listUpdateIndex).setEmail(email);
                TherapistList.get(listUpdateIndex).setLicense(license);
                TherapistList.get(listUpdateIndex).setExperience(experience);
                TherapistList.get(listUpdateIndex).setGender(gender);

                passwordArr.set(jsonUpdateIndex, password);
                phoneArr.set(jsonUpdateIndex, phone);
                emailArr.set(jsonUpdateIndex, email);
                licenseArr.set(jsonUpdateIndex, license);
                experienceArr.set(jsonUpdateIndex, experience);
                genderArr.set(jsonUpdateIndex, gender);

                userData.put("gender", genderArr);
                userData.put("experience", experienceArr);
                userData.put("license", licenseArr);
                userData.put("email", emailArr);
                userData.put("phone", phoneArr);
                userData.put("password", passwordArr);

                try (FileWriter fileWrite = new FileWriter(System.getProperty("user.dir") +
                        "\\src\\main\\java\\com\\doraemon\\iamfine\\data\\" + "userData.json")) {

                    fileWrite.write(userData.toJSONString());
                    fileWrite.flush();

                } catch (IOException ef) {
                    ef.printStackTrace();
                }

            } else { // cancel remove operation and notify user

            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (ParseException f) {
            f.printStackTrace();
        }

    }

}
