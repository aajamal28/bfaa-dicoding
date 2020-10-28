package com.example.mysubmission1bfaa;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int photo;
    private String username;
    private String name;
    private String location;
    private String company;
    private String repo;
    private String follower;
    private String following;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    protected User(Parcel in){
        this.name = in.readString();
        this.username = in.readString();
        this.location = in.readString();
        this.company = in.readString();
        this.repo = in.readString();
        this.follower = in.readString();
        this.following = in.readString();
        this.photo = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.username);
        dest.writeString(this.location);
        dest.writeString(this.company);
        dest.writeString(this.repo);
        dest.writeString(this.follower);
        dest.writeString(this.following);
        dest.writeInt(this.photo);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
