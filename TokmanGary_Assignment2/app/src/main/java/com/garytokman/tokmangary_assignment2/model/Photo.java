package com.garytokman.tokmangary_assignment2.model;

/**
 * Created by gtokman1 on 8/24/16.
 */
public class Photo {

    // Fields
    private String mTitle;
    private String mName;
    private String mImageUrlSmall;

    public Photo(String title, String name, String imageUrlSmall) {
        mTitle = title;
        mName = name;
        mImageUrlSmall = imageUrlSmall;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getName() {
        return mName;
    }

    public String getImageUrlSmall() {
        return mImageUrlSmall;
    }

    @Override
    public String toString() {
        return mTitle + " by " + mName;
    }
}
