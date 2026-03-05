package com.socialmedia.service;
import com.socialmedia.dao.*;
import com.socialmedia.model.*;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) { this.userDAO = userDAO; }

    public void signUp(String name, String dob, int age, String location, String occupation) {
        User user = new User(name, dob, age, location, occupation);
        userDAO.addUser(user);
        System.out.println("User signed up successfully: " + name);
    }

    public User findUser(String name) { return userDAO.findByName(name); }

    public List<User> getAllUsers() { return userDAO.getAllUsers(); }
}