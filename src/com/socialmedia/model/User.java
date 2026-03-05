package com.socialmedia.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String dob;
    private int age;
    private String location;
    private String occupation;

    private List<User> friends = new ArrayList<>();
    private List<User> friendRequests = new ArrayList<>();

    public User(String name, String dob, int age, String location, String occupation) {
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.location = location;
        this.occupation = occupation;
    }

    public String getName() { return name; }
    public String getDob() { return dob; }
    public int getAge() { return age; }
    public String getLocation() { return location; }
    public String getOccupation() { return occupation; }

    public List<User> getFriends() { return friends; }
    public List<User> getFriendRequests() { return friendRequests; }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Location: " + location + " | Occupation: " + occupation;
    }
}