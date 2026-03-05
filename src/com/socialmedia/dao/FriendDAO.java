package com.socialmedia.dao;

import java.util.List;

import com.socialmedia.model.*;

public class FriendDAO {

    public void sendRequest(User sender, User receiver) {
        receiver.getFriendRequests().add(sender);
        System.out.println(sender.getName() + " sent a friend request to " + receiver.getName());
    }

    public void acceptRequest(User user, User sender) {
        user.getFriends().add(sender);
        sender.getFriends().add(user);
        user.getFriendRequests().remove(sender);
        System.out.println(user.getName() + " accepted friend request from " + sender.getName());
    }

    public void rejectRequest(User user, User sender) {
        user.getFriendRequests().remove(sender);
        System.out.println(user.getName() + " rejected friend request from " + sender.getName());
    }

    public void viewFriends(User user) {
        List<User> friends = user.getFriends();
        if(friends.isEmpty()) {
            System.out.println("No friends yet.");
        } else {
            System.out.println(user.getName() + "'s friends:");
            for(User u : friends) System.out.println("- " + u);
        }
    }

    public void viewRequests(User user) {
        List<User> requests = user.getFriendRequests();
        if(requests.isEmpty()) {
            System.out.println("No pending friend requests.");
        } else {
            System.out.println("Pending requests:");
            for(User u : requests) System.out.println("- " + u);
        }
    }
}