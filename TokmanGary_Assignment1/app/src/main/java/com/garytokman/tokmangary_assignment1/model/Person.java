package com.garytokman.tokmangary_assignment1.model;

/**
 * Created by gtokman1 on 8/12/16.
 */
public class Person {

    private String mName;
    private int mAge;
    private int mProfileImage;

    public Person(String name, int age, int profileImage) {
        mName = name;
        mAge = age;
        mProfileImage = profileImage;
    }

    @Override
    public String toString() {
        return  mName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public int getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(int profileImage) {
        mProfileImage = profileImage;
    }
}
