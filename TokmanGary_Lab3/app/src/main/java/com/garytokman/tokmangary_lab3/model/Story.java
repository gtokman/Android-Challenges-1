package com.garytokman.tokmangary_lab3.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gtokman1 on 8/6/16.
 */
public class Story implements Parcelable {
    // Fields
    private String mName;
    private String mStory;
    private String mImage;

    public Story(String name, String story, String image) {
        mName = name;
        mStory = story;
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getStory() {
        return mStory;
    }

    public void setStory(String story) {
        mStory = story;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    @Override
    public String toString() {
        return "My name is " + mName + " and this is my story... \n\n" + mStory;
    }

    // Allow object to be Parcelable required to pass objects in intents
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mStory);
        parcel.writeString(mImage);
    }

    public static final Parcelable.Creator<Story> CREATOR
            = new Parcelable.Creator<Story>() {
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        public Story[] newArray(int size) {
            return new Story[size];
        }
    };

    private Story(Parcel in) {
        mName = in.readString();
        mStory = in.readString();
        mImage = in.readString();
    }
}
