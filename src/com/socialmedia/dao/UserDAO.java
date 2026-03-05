package com.socialmedia.dao;

import java.util.ArrayList;
import java.util.List;
import com.socialmedia.model.*;

public class UserDAO {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) { users.add(user); }

    public List<User> getAllUsers() { return users; }

    public User findByName(String name) {
        for(User u : users) {
            if(u.getName().equalsIgnoreCase(name)) return u;
        }
        return null;
    }
}