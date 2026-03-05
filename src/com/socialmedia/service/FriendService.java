package com.socialmedia.service;
import com.socialmedia.dao.*;
import com.socialmedia.model.*;
import java.util.List;

public class FriendService {
    private FriendDAO friendDAO;

    public FriendService(FriendDAO friendDAO) { this.friendDAO = friendDAO; }

    public void sendRequest(User sender, User receiver) { friendDAO.sendRequest(sender, receiver); }
    public void acceptRequest(User user, User sender) { friendDAO.acceptRequest(user, sender); }
    public void rejectRequest(User user, User sender) { friendDAO.rejectRequest(user, sender); }
    public void viewFriends(User user) { friendDAO.viewFriends(user); }
    public void viewRequests(User user) { friendDAO.viewRequests(user); }

    public void suggestFriends(User current, List<User> allUsers) {
        System.out.println("\nFriend Suggestions for " + current.getName() + ":");
        for(User u : allUsers) {
            if(u != current && !current.getFriends().contains(u)) {
                System.out.println("- " + u);
            }
        }
    }
}