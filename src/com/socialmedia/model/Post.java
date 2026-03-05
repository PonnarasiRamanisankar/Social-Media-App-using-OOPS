package com.socialmedia.model;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private User author;
    private String content;
    private int likes = 0;
    private List<String> comments = new ArrayList<>();

    public Post(User author, String content) {
        this.author = author;
        this.content = content;
    }

    public User getAuthor() { return author; }
    public String getContent() { return content; }
    public int getLikes() { return likes; }
    public List<String> getComments() { return comments; }

    public void like() { likes++; }
    public void comment(String c) { comments.add(c); }

    @Override
    public String toString() {
        return author.getName() + ": " + content + " | Likes: " + likes + " | Comments: " + comments.size();
    }
}