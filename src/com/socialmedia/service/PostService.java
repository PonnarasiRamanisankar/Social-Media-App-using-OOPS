package com.socialmedia.service;
import com.socialmedia.dao.*;
import com.socialmedia.model.*;

public class PostService {
    private PostDAO postDAO;

    public PostService(PostDAO postDAO) { this.postDAO = postDAO; }

    public void createPost(User user, String content) { postDAO.createPost(user, content); }
    public void showNewsFeed(User user) { postDAO.showNewsFeed(user); }
}