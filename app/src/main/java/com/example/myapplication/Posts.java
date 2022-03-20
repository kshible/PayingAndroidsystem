package com.example.myapplication;

public class Posts {
    private String name;
    private String date;
    private  String body;
    private int follower;
    private int follwing;
    private int posts;
    private int img;
    public Posts(String name, String date, String body, int follower, int follwing, int posts) {
        this.name = name;
        this.date = date;
        this.body = body;
        this.follower = follower;
        this.follwing = follwing;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollwing() {
        return follwing;
    }

    public void setFollwing(int follwing) {
        this.follwing = follwing;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }
}
