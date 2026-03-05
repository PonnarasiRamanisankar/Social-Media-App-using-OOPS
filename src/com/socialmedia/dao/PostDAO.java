package com.socialmedia.dao;

import java.util.ArrayList;
import java.util.List;
import com.socialmedia.model.*;
 
public class PostDAO {
    private List<Post> posts = new ArrayList<>();

    public void createPost(User user, String content) {
        posts.add(0, new Post(user, content));
        System.out.println("Post created successfully!");
    }

    public void showNewsFeed(User user) {
        System.out.println("\nNews Feed for " + user.getName() + ":");
        for(Post p : posts) {
            if(user.getFriends().contains(p.getAuthor()) || p.getAuthor() == user) {
                System.out.println(p);
            }
        }
    }
}