package com.garytokman.tokmangary_ce06.model;

/**
 * Created by gtokman1 on 8/11/16.
 */
public class Person {
    // Fields
    private String mFirstName;
    private String mLastName;
    private String mBirthday;
    private int mPicture;

    public Person(String firstName, String lastName, String birthday, int picture) {
        mFirstName = firstName;
        mLastName = lastName;
        mBirthday = birthday;
        mPicture = picture;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public void setBirthday(String birthday) {
        mBirthday = birthday;
    }

    public void setPicture(int picture) {
        mPicture = picture;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public int getPicture() {
        return mPicture;
    }
}
